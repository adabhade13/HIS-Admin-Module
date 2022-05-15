package com.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.domain.Account;
import com.his.service.AccountMgmtService;
import com.his.utils.AppConstants;

@Controller
public class ViewAccountMgmtController {
	
	 @Autowired
	   private AccountMgmtService accountService;
	 
	@GetMapping(value = "/getAllAccount")
	public String loadAccountDetails(Model model) {
		List<Account> accounts = accountService.getAllAccount();
		model.addAttribute("accounts", accounts);
		List<String> roles = accountService.getRoles();
		if(roles !=null) {
			model.addAttribute("roles", roles);
		}
		return "viewAccount";
	}

	@GetMapping(value = "/editAccount")
	public String editAccount(@RequestParam("accId")Integer accId,Model model) {
		Account account = accountService.getEditAccount(accId);
		model.addAttribute("account", account);
		List<String> roles = accountService.getRoles();
		if(roles !=null) {
			model.addAttribute("roles", roles);
		}
		return "account";
	}
	
	@GetMapping(value = "/deleteAccount")
	public String deleteAccount(@RequestParam("accId")Integer accId,Model model,String update) {
		
		Account account = accountService.findAccountId(accId);
		if(account.getAccId() != null) {
			account.setIsDeleted(AppConstants.NO);
			if(Boolean.parseBoolean(update)) {
				account.setIsDeleted(AppConstants.YES);
			}
			boolean updateAccountMgmt = accountService.updateAccountMgmt(account);
			if(updateAccountMgmt) {
			  return "redirect:/getAllAccount";	
			}
		}
		return null;
	}
}
