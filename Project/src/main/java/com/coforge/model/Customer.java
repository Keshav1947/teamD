package com.coforge.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private int  age;
	private String gender;
	private int registrationNo;
	private String phoneNo;
	private String customerName;
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(referencedColumnName= "id", nullable = false)
	@JsonBackReference
	private Branch branch;

	public Customer() {
		super();
	}	
	public Customer(Long id, int age, String gender, int registrationNo, String phoneNo, String customerName) {
		super();
		Id = id;
		this.age = age;
		this.gender = gender;
		this.registrationNo = registrationNo;
		this.phoneNo = phoneNo;
		this.customerName = customerName;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(int registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
}
