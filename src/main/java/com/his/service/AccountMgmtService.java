package com.his.service;

import java.util.List;

import com.his.domain.Account;

public interface AccountMgmtService {
	
	public List<String> getRoles();
	
	public boolean saveAccountInfo(Account account);
	
	public Account getEditAccount(Integer accId);
	
	public List<Account> getAllAccount();
	
	public Account findAccountByTempPwd(String tempPwd);
	
	public boolean updateAccountMgmt(Account account);
	
	public Account findAccountId(Integer accId);
	
	public boolean getDeleteAccount(Integer accId);
}
