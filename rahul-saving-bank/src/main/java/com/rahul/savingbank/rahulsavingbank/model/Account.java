package com.rahul.savingbank.rahulsavingbank.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -431438419152420715L;
	private Long id;
	private Long accountNumber;
	private String ifscCode;
	private String branch;
	private long amount;
	private String created;
	@JsonManagedReference
	private List<Transaction> transactions;

	public Account() {
	}

	public Account(Long accountNumber, String ifscCode, String branch, long amount, String created) {
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.branch = branch;
		this.amount = amount;
		this.created = created;
	}

	public Account(Long id, Long accountNumber, String ifscCode, String branch, long amount, String created) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.branch = branch;
		this.amount = amount;
		this.created = created;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + ", branch="
				+ branch + ", amount=" + amount + ", created=" + created + ", transactions=" + transactions + "]";
	}

}
