package com.rahul.savingbank.rahulsavingbank.model;

public class Inquiry {

	private Long id;
	private String email;
	private String issue;

	public Inquiry() {
	}

	public Inquiry(String email, String issue) {
		this.email = email;
		this.issue = issue;
	}

	public Inquiry(Long id, String email, String issue) {
		this.id = id;
		this.email = email;
		this.issue = issue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	@Override
	public String toString() {
		return "Inquiry [id=" + id + ", email=" + email + ", issue=" + issue + "]";
	}
}
