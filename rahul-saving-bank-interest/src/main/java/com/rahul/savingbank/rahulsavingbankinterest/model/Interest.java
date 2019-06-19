package com.rahul.savingbank.rahulsavingbankinterest.model;

import java.io.Serializable;

public class Interest implements Serializable {

	private static final long serialVersionUID = -4421408797736006995L;

	private Long id;

	private long accountNumber;

	private double amount;
	
	public Interest() {
		super();
	}

	public Interest(long account, double amount) {
		super();
		this.accountNumber = account;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Interest [id=" + id + ", accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}

}
