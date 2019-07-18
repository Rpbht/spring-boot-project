package com.rahul.bank.rahulsavingbankaccountapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "account_tbl")
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4416431624631730585L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long id;

	@Column(name = "accountNumber")
	private Long accountNumber;

	@Column(name = "ifscCode")
	private String ifscCode;

	@Column(name = "branch")
	private String branch;

	@Column(name = "amount")
	private double amount;

	@Column(name = "created")
	private String created;

	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL,mappedBy="account",fetch=FetchType.EAGER)
	private List<Transaction> transactions;

	public Account() {
	}

	public Account(Long accountNumber, String ifscCode, String branch, double amount, String created) {
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.branch = branch;
		this.amount = amount;
		this.created = created;
	}

	public Account(Long id, Long accountNumber, String ifscCode, String branch, double amount, String created) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.branch = branch;
		this.amount = amount;
		this.created = created;
	}

	public Account(Long id, Long accountNumber, String ifscCode, String branch, double amount, String created,
			List<Transaction> transactions) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.branch = branch;
		this.amount = amount;
		this.created = created;
		this.transactions = transactions;
	}

	public Account(Long accountNumber, String ifscCode, String branch, double amount, String created,
			List<Transaction> transactions) {
		super();
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.branch = branch;
		this.amount = amount;
		this.created = created;
		this.transactions = transactions;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
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
