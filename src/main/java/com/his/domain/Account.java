package com.his.domain;

import javax.persistence.Column;

public class Account {

	private Integer accId;
	private String fname;
	private String lname;
	private String email;
	private String gender;
	private String role;
	private String status;
	private String pazzword;
	private String isDeleted;

	public Account() {

	}
	public Integer getAccId() {
		return accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPazzword() {
		return pazzword;
	}
	public void setPazzword(String pazzword) {
		this.pazzword = pazzword;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "Account [accId=" + accId + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", gender="
				+ gender + ", role=" + role + ", status=" + status + ", pazzword=" + pazzword + ", isDeleted="
				+ isDeleted + "]";
	}
	
}
