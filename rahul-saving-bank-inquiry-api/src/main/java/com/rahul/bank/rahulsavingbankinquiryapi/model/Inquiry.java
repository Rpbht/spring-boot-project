package com.rahul.bank.rahulsavingbankinquiryapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="inquiry_tbl")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Inquiry implements Serializable{

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="inquiry_id")
		private Long id;
		
		@Column(name="email")
		private String email;
		
		@Column(name="issue")
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

