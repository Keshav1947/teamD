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
	
	
	private String carddate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(referencedColumnName= "id", nullable = false)
//	@JsonBackReference
	private Card card;
	
	public CardList() {
		// TODO Auto-generated constructor stub
	}

	public CardList(Long id, Customer customer, String carddate, Card card) {
		super();
		Id = id;
		this.customer = customer;
		this.carddate = carddate;
		this.card = card;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCarddate() {
		return carddate;
	}

	public void setCarddate(String carddate) {
		this.carddate = carddate;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "CardList [Id=" + Id + ", customer=" + customer + ", carddate=" + carddate + ", card=" + card + "]";
	}

	
	
	
	
}


	