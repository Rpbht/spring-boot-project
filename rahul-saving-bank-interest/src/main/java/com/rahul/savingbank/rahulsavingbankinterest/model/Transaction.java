package com.rahul.savingbank.rahulsavingbankinterest.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7265667058750317996L;
	private Long id;
	private String ticket;
	private double amount;
	private Long accountNumber;
	private String created;
	@JsonBackReference
	private Account intended;

	public Transaction() {
	}

	public Transaction(String ticket, double amount, Long accountNumber, String created) {
		this.ticket = ticket;
		this.amount = amount;
		this.accountNumber = accountNumber;
		this.created = created;
	}

	public Transaction(Long id, String ticket, double amount, Long accountNumber, String created) {
		this.id = id;
		this.ticket = ticket;
		this.amount = amount;
		this.accountNumber = accountNumber;
		this.created = created;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
	
	

	public Account getIntended() {
		return intended;
	}

	public void setIntended(Account intended) {
		this.intended = intended;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", ticket=" + ticket + ", amount=" + amount + ", accountNumber="
				+ accountNumber + ", created=" + created + "]";
	}

}
