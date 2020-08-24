package com.his.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.entity.AccountEntity;

public interface AccountMgmtRepository  extends JpaRepository<AccountEntity, Serializable>{

	
	public AccountEntity findByPazzword(String tempPwd);
	
	public AccountEntity findByAccId(Integer accId);
}
