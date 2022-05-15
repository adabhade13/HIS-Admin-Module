package com.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.his.domain.Account;
import com.his.service.AccountMgmtService;

@Controller
public class AccountMgmtController {
	
   @Autowired
   private AccountMgmtService accountService;
   
    @Autowired
   //private AccountMgmtService accountService;
   
   @GetMapping(value = {"/","/addAccount"})
	public String loadForm(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		List<String> roles = accountService.getRoles();
		String sb = null;
		if(roles !=null) {
			model.addAttribute("roles", roles);
		}
		return "account";
	}
   
   @PostMapping(value = "/saveAccount")
   public String saveEmployee(@ModelAttribute("account") Account account,Model model) {
	     boolean isSaved = false;
		 isSaved = accountService.saveAccountInfo(account);
		 
			/*
			 * if(isSaved) { model.addAttribute("succMsg", "Role Created SuccessFully..!");
			 * }else { model.addAttribute("errMsg",
			 * "Something went wrong.. please try again..!"); }
			 */
	     return "succEmail";
	   
   }

}
