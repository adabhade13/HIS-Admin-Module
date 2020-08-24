package com.his.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "account_mgmt")
public class AccountEntity {
	
	private Integer accId;
	private String fname;
	private String lname;
	private String email;
	private String gender;
	private String role;
	private String status;
	private String pazzword;
	private String isDeleted;
	private Date createdDate;
	private Date updatedDate;
	
	
	@Id
	@SequenceGenerator(name = "acc_id",
	                   allocationSize = 1,
	                   sequenceName = "acc_id_seq")
	
	@GeneratedValue(generator = "acc_id",strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}
	
	@Column(name = "emp_firstname")
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Column(name = "emp_lastname")
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name = "role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="pazzword")
	public String getPazzword() {
		return pazzword;
	}
	public void setPazzword(String pazzword) {
		this.pazzword = pazzword;
	}
	@Column(name="isDeleted")
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "createdDate" , updatable = false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "updatedDate" , insertable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

}
