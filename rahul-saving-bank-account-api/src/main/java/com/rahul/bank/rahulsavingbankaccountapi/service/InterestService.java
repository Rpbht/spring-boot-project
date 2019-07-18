package com.rahul.bank.rahulsavingbankaccountapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.bank.rahulsavingbankaccountapi.model.Interest;
import com.rahul.bank.rahulsavingbankaccountapi.repository.InterestRepository;

@Service
public class InterestService {

	@Autowired
	private InterestRepository interestRepository;

	public Interest saveInterest(Interest interest) {

		return interestRepository.save(interest);
	}
	
	public List<Interest> getAllInterest(){
		
		return interestRepository.findAll();
	}
	
	@Transactional
	public Integer updateInterest(Interest interest){
		return interestRepository.updateInterest(interest.getAccountNumber(), interest.getAmount());
	}
	
	
	
	public Interest findByAccountNumber(long accountNumber){
		return interestRepository.findByAccountNumber(accountNumber);
	}
}
