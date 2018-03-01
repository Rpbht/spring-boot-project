package com.rahul.savingbank.rahulsavingbank.model;

public class Account {

	private Long id;
	private Long accountNumber;
	private String ifscCode;
	private String branch;
	private long amount;
	private String created;

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

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + ", branch="
				+ branch + ", amount=" + amount + ", created=" + created + "]";
	}

}
