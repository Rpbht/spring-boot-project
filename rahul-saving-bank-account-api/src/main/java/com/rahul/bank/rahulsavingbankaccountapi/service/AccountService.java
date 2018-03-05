package com.rahul.bank.rahulsavingbankaccountapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rahul.bank.rahulsavingbankaccountapi.model.Account;
import com.rahul.bank.rahulsavingbankaccountapi.repository.AccountRepository;
import com.rahul.bank.rahulsavingbankaccountapi.utils.ConstantValues;

@Service
public class AccountService {
	
	@Autowired
	protected AccountRepository accountRepository;

	public Account getAccount(Long id) {
		return accountRepository.getOne(id);
	}
	
	public List<Account> getAllAccounts(){
		return accountRepository.findAll();
	}
	
	public Account saveAccount(Account account){
		return accountRepository.save(account);
	}
	
	public String deleteAccount(Long id){
		accountRepository.deleteById(id);
		return ConstantValues.ACCOUNT_DELETED;
	}
	
	public String deleteAccount(){
		accountRepository.deleteAll();
		return ConstantValues.ALL_ACCOUNT_DELETED;
	}
	
	public Account findAccount(Long number){
		return accountRepository.findByAccountNumber(number);
	}
}
