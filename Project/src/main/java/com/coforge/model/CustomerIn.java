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
@Table(name = "customerin")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerIn {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String datein;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
	private Customer customer;
	
	public CustomerIn() {
		// TODO Auto-generated constructor stub
	}

	public CustomerIn(Long id, String datein, Customer customer) {
		super();
		Id = id;
		this.datein = datein;
		this.customer = customer;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDatein() {
		return datein;
	}

	public void setDatein(String datein) {
		this.datein = datein;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerIn [Id=" + Id + ", datein=" + datein + ", customer=" + customer + "]";
	}

	
	
	
}
