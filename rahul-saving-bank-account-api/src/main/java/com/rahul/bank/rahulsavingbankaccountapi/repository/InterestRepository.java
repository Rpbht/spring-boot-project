package com.rahul.bank.rahulsavingbankaccountapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.bank.rahulsavingbankaccountapi.model.Interest;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
	
	@Modifying
	@Transactional
	@Query("update Interest i set i.amount = ?2 where i.accountNumber = ?1")
	Integer updateInterest(long accountNumber, double amount);
	
	Interest findByAccountNumber(long accountNumber);

}
