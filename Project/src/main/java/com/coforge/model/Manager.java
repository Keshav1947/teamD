package com.coforge.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "manager")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Manager {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private String fname;
	private String address;
	private String phoneno;
	private String email;
	private boolean availability;
	
	private Branch branch;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Manager(Long id, String name, String fname, String address, String phoneno, String email,
			boolean availability, Branch branch) {
		super();
		Id = id;
		this.name = name;
		this.fname = fname;
		this.address = address;
		this.phoneno = phoneno;
		this.email = email;
		this.availability = availability;
		this.branch = branch;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean getAvailability() {
		return availability;
	}


	public void setAvailability(boolean availability) {
		this.availability = availability;
	}


	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
	public Branch getBranch() {
		return branch;
	}


	public void setBranch(Branch branch) {
		this.branch = branch;
	}


	@Override
	public String toString() {
		return "Manager [Id=" + Id + ", name=" + name + ", fname=" + fname + ", address=" + address + ", phoneno="
				+ phoneno + ", email=" + email + ", availability=" + availability + ", branch=" + branch + "]";
	}

}
