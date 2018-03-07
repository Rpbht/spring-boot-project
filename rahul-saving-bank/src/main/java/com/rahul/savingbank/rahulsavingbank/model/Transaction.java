package com.rahul.savingbank.rahulsavingbank.model;

public class Transaction {

	private Long id;
	private String ticket;
	private Long amount;
	private Long accountNumber;
	private String created;
	private Account accountDetails;

	public Transaction() {
	}

	public Transaction(String ticket, Long amount, Long accountNumber, String created) {
		this.ticket = ticket;
		this.amount = amount;
		this.accountNumber = accountNumber;
		this.created = created;
	}

	public Transaction(Long id, String ticket, Long amount, Long accountNumber, String created) {
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
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

	public Account getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(Account accountDetails) {
		this.accountDetails = accountDetails;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", ticket=" + ticket + ", amount=" + amount + ", accountNumber="
				+ accountNumber + ", created=" + created + ", accountDetails=" + accountDetails + "]";
	}
}
