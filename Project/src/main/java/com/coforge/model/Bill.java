package com.coforge.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "bill")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bill {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private long discount;
	private long paidamount;
	private String bdate;
	private String bmethod;
	private long billamount;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
	private Customer customer;
	

	public Bill() {
		// TODO Auto-generated constructor stub
	}


	public Bill(Long id, long discount, long paidamount, String bdate, String bmethod, long billamount,
			Customer customer) {
		super();
		Id = id;
		this.discount = discount;
		this.paidamount = paidamount;
		this.bdate = bdate;
		this.bmethod = bmethod;
		this.billamount = billamount;
		this.customer = customer;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public long getDiscount() {
		return discount;
	}


	public void setDiscount(long discount) {
		this.discount = discount;
	}


	public long getPaidamount() {
		return paidamount;
	}


	public void setPaidamount(long paidamount) {
		this.paidamount = paidamount;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	public String getBmethod() {
		return bmethod;
	}


	public void setBmethod(String bmethod) {
		this.bmethod = bmethod;
	}


	public long getBillamount() {
		return billamount;
	}


	public void setBillamount(long billamount) {
		this.billamount = billamount;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Bill [Id=" + Id + ", discount=" + discount + ", paidamount=" + paidamount + ", bdate=" + bdate
				+ ", bmethod=" + bmethod + ", billamount=" + billamount + ", customer=" + customer + "]";
	}
	

	
	
}
