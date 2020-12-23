package com.coforge.model;

import java.time.format.DateTimeFormatter;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customerout")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerOut {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long Id;
		
		
		private String dateout;
		
		private long totalDays;
		
		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(referencedColumnName = "id")
		private Customer customer;
		
		public CustomerOut() {
			// TODO Auto-generated constructor stub
		}

		public CustomerOut(Long id, String dateout, long totalDays, Customer customer) {
			super();
			Id = id;
			this.dateout = dateout;
			this.totalDays = totalDays;
			this.customer = customer;
		}

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getDateout() {
			return dateout;
		}

		public void setDateout(String dateout) {
			this.dateout = dateout;
		}

		public long getTotalDays() {
			return totalDays;
		}

		public void setTotalDays(long totalDays) {
			this.totalDays = totalDays;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "CustomerOut [Id=" + Id + ", dateout=" + dateout + ", totalDays=" + totalDays + ", customer="
					+ customer + "]";
		}

		

		
	}

