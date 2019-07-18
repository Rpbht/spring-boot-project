package com.rahul.bank.rahulsavingbankaccountapi.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.bank.rahulsavingbankaccountapi.model.Transaction;
import com.rahul.bank.rahulsavingbankaccountapi.service.TransactionService;
import com.rahul.bank.rahulsavingbankaccountapi.utils.ConstantValues;

@RestController
@RequestMapping(value = "/data")
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@RequestMapping(value = "account/{number}", method = RequestMethod.GET)
	public List<Transaction> findTransactionByAccountNumber(@PathVariable Long number) {
		return service.findTransactionByAccountNumber(number);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Transaction> getAllTransaction() {
		return service.getAllTransaction();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Transaction saveTranasction(@RequestBody Transaction transaction, HttpServletRequest request) throws IOException {
		System.out.println("Called:  "+transaction);
		return service.saveTransaction(transaction);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteAllTransaction() {
		service.deleteAllTransaction();
		return ConstantValues.ALL_TRANSACTION_REMOVED;
	}
}
