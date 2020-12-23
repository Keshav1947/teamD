package com.coforge.model;

import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "cardlist")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CardList {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
	private Customer customer;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(referencedColumnName= "id", nullable = false)
	@JsonBackReference
	private Card card;
	
	public CardList() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
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

	public CardList(Long id, Card card, Date date, Customer customer) {
		super();
		Id = id;
		this.card = card;
		this.date = date;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CardList [Id=" + Id + ", card=" + card + ", date=" + date + ", customer=" + customer + "]";
	}
	
	
	
}


	