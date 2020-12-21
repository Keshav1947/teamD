package com.coforge.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customerin")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerIn {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
	private Customer customer;
	
	public CustomerIn() {
		// TODO Auto-generated constructor stub
	}

	public CustomerIn(Long id, Date date, Customer customer) {
		super();
		Id = id;
		this.date = date;
		this.customer = customer;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerIn [Id=" + Id + ", date=" + date + ", customer=" + customer + "]";
	}
	
	
	
	
}
