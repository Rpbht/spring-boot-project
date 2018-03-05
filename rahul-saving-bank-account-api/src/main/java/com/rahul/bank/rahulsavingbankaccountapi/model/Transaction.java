package com.rahul.bank.rahulsavingbankaccountapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="transaction_tbl")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private Long id;
	
	@Column(name="ticket")
	private String ticket;
	
	@Column(name="amount")
	private Long amount;
	
	@Column(name="accountNumber")
	private Long accountNumber;
	
	@Column(name="created")
	private String created;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="account_id")
	private Account account;

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", ticket=" + ticket + ", amount=" + amount + ", accountNumber="
				+ accountNumber + ", created=" + created + ", account=" + account + "]";
	}

}
