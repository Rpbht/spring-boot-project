package com.rahul.bank.rahulsavingbankaccountapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rahul.bank.rahulsavingbankaccountapi.model.Account;
import com.rahul.bank.rahulsavingbankaccountapi.service.AccountService;
import com.rahul.bank.rahulsavingbankaccountapi.utils.ConstantValues;

@RestController
public class AccountController {

	@Autowired
	private AccountService service;

	@RequestMapping(value = "/{number}", method = RequestMethod.GET)
	public Account findAccount(@PathVariable Long number) {
		return service.findAccount(number);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Account> getAllAccounts() {
		return service.getAllAccounts();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Account saveAccount(@RequestBody Account account) {
		
		System.out.println("Account edit called: "+account);
		
		return service.saveAccount(account);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Account editAccount(@RequestBody Account account) {
		return service.saveAccount(account);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteAccount(@PathVariable Long id) {
		service.deleteAccount(id);
		return ConstantValues.ACCOUNT_DELETED;
	}

	public String deleteAllAccount() {
		service.deleteAccount();
		return ConstantValues.ALL_ACCOUNT_DELETED;
	}
}
