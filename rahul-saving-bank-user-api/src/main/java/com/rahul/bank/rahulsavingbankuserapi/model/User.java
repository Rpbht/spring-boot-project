package com.rahul.bank.rahulsavingbankuserapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user_tbl")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="city")
	private String city;
	
	@Column(name="accountNumber")
	private Long accountNumber;
	
	@Column(name="mobileNumber")
	private Long mobileNumber;
	
	@Column(name="created")
	private String created;
	
	@Column(name="modifided")
	private String modifided;

	public User() {
	}

	public User(String firstName, String lastName, String gender, String email, String password, String city,
			Long accountNumber, Long mobileNumber, String created, String modifided) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.city = city;
		this.accountNumber = accountNumber;
		this.mobileNumber = mobileNumber;
		this.created = created;
		this.modifided = modifided;
	}

	public User(Long id, String firstName, String lastName, String gender, String email, String password, String city,
			Long accountNumber, Long mobileNumber, String created, String modifided) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.city = city;
		this.accountNumber = accountNumber;
		this.mobileNumber = mobileNumber;
		this.created = created;
		this.modifided = modifided;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModifided() {
		return modifided;
	}

	public void setModifided(String modifided) {
		this.modifided = modifided;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", email=" + email + ", password=" + password + ", city=" + city + ", accountNumber=" + accountNumber
				+ ", mobileNumber=" + mobileNumber + ", created=" + created + ", modifided=" + modifided + "]";
	}
}
