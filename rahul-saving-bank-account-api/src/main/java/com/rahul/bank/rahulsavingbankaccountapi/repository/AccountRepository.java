package com.rahul.bank.rahulsavingbankaccountapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.bank.rahulsavingbankaccountapi.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public Account findByAccountNumber(long accountNumber);

}
