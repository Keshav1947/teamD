package com.coforge.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "card")
public class Card {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	private int group_limit;
	private Long discount;
	private Long amount;
	private Long duration;
		
	
	
	private boolean availability;

	

	public Card() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Card(Long id, String name, int group_limit, Long discount, Long amount, Long duration,
			boolean availability) {
		super();
		Id = id;
		this.name = name;
		this.group_limit = group_limit;
		this.discount = discount;
		this.amount = amount;
		this.duration = duration;
		this.availability = availability;
	}

	





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

	public int getGroup_limit() {
		return group_limit;
	}

	public void setGroup_limit(int group_limit) {
		this.group_limit = group_limit;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	
	
    	

}



	