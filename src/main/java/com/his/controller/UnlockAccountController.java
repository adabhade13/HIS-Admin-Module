package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.domain.Account;
import com.his.domain.UnlockAccount;
import com.his.service.AccountMgmtService;
import com.his.utils.AppConstants;

@Controller
public class UnlockAccountController {

	   @Autowired
	   private AccountMgmtService accountService;

	 @GetMapping(value = "/web")
	public String loadUnlockAccForm() {
		return "Welcome";
	}



	@GetMapping(value = "/unlockAcc")
	public String loadUnlockAccForm(@RequestParam("email")String email,Model model) {

		model.addAttribute("email", email);
		UnlockAccount unlockAcc = new UnlockAccount();

		model.addAttribute("unlockAcc", unlockAcc);
		return "unlockAcc";
	}

	@PostMapping(value="/updateUnlockAcc")
	public String saveUnlockAccount(@ModelAttribute("unlockAcc")UnlockAccount unlockAccount,Model model) {

		Account account = accountService.findAccountByTempPwd(unlockAccount.getTempPwd());

		if(account.getAccId() != null) {

			account.setStatus(AppConstants.APP_UNLOCKED);
			account.setPazzword(unlockAccount.getNewPwd());
			boolean isUpdateAccount = accountService.updateAccountMgmt(account);

		   if(isUpdateAccount) {
			return "unlockSucc";
		   }
		}
		model.addAttribute("errMsg", "Please Enter correct Temporary password");
		return "unlockError";
	}

@GetMapping(value = "/greeting")
	public String greeting(){
		return "Welcome";
	}
}
