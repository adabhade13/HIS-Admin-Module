package com.his.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.domain.Account;
import com.his.entity.AccountEntity;
import com.his.repository.AccountMgmtRepository;
import com.his.repository.RoleRepository;
import com.his.utils.AppConstants;
import com.his.utils.EmailUtils;
import com.his.utils.TempPwdUtils;

@Service
public class AccountMgmtServiceImpl implements AccountMgmtService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private AccountMgmtRepository accountRepo;
	
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getRoles() {
		return roleRepo.findRoleName();
	}

	@Override
	public boolean saveAccountInfo(Account account){
	    AccountEntity entity = new AccountEntity();
	    entity.setStatus(AppConstants.APP_LOCKED);
	    entity.setIsDeleted(AppConstants.NO);
	    String tempPazzword = TempPwdUtils.generateTempPazzword();
	    entity.setPazzword(tempPazzword);
	    BeanUtils.copyProperties(account, entity);
	    AccountEntity saved = accountRepo.save(entity);
	    if(saved.getAccId() !=null && saved.getEmail() !=null) {
	    	String subject="Unlock Account";
	    	//EmailUtils emailUtils = new EmailUtils();
	    	emailUtils.sendEmail(saved.getEmail(), subject,saved);
	    }
		return saved != null;
	}

	@Override
	public Account getEditAccount(Integer accId) {
		Optional<AccountEntity> optional = accountRepo.findById(accId);
		Account account=null;
		if(optional.isPresent()) {
			AccountEntity entity = optional.get();
			account = new Account();
			BeanUtils.copyProperties(entity, account);
			return account;
		}
		return null;
	}

	@Override
	public List<Account> getAllAccount() {
    
	 List<Account> accounts = new ArrayList<>();
     List<AccountEntity> entities = accountRepo.findAll();
     for(AccountEntity entity : entities) {
    	 Account account = new Account();
    	 BeanUtils.copyProperties(entity, account);
    	 accounts.add(account);
     }
		return accounts;
	}

	@Override
	public Account findAccountByTempPwd(String tempPwd) {
		AccountEntity findByPazzword = accountRepo.findByPazzword(tempPwd);
		Account account = new Account();
		BeanUtils.copyProperties(findByPazzword, account);
		return account; 
	}

	@Override
	public Account findAccountId(Integer accId) {
		AccountEntity findByPazzword = accountRepo.findByAccId(accId);
		Account account = new Account();
		BeanUtils.copyProperties(findByPazzword, account);
		return account; 
	}

	@Override
	public boolean updateAccountMgmt(Account account) {
		 AccountEntity entity = new AccountEntity();
		    BeanUtils.copyProperties(account, entity);
		    AccountEntity saved = accountRepo.save(entity);
		return saved.getAccId() != null;
	}

	@Override
	public boolean getDeleteAccount(Integer accId) {
		accountRepo.deleteById(accId);
		return true;
	}

	

}
