package com.rahul.bank.rahulsavingbankaccountapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.bank.rahulsavingbankaccountapi.model.Transaction;
import com.rahul.bank.rahulsavingbankaccountapi.repository.TransactionRepository;
import com.rahul.bank.rahulsavingbankaccountapi.utils.ConstantValues;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repository;
	
	public Transaction findTransaction(Long accountNumber){
		return repository.findByAccountDetails(accountNumber);
	}
	
	public List<Transaction> findTransactionByAccountNumber(Long accountNumber){
		
		return repository.findByAccountNumber(accountNumber);
	}
	
	public Transaction getTransaction(Long id){
		return repository.getOne(id);
	}
	
	public List<Transaction> getAllTransaction(){
		return repository.findAll();
	}
	
	public Transaction saveTransaction(Transaction transaction){
		return repository.save(transaction);
	}
	
	public String deleteTransaction(Long id){
		repository.deleteById(id);
		return ConstantValues.TRANSACTION_REMOVED;
	}
	
	public String deleteAllTransaction(){
		repository.deleteAll();
		return ConstantValues.ALL_TRANSACTION_REMOVED;
	}
}
