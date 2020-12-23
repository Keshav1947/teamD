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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "branchs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Branch  {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String district;
	private String state;
	private boolean availability;
	
	@OneToMany(mappedBy = "branch", fetch = FetchType.EAGER,
			cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private Set<Customer> customer;
		
	public Branch() {
		// TODO Auto-generated constructor stub
	}
	public Branch(Long id, String district, String state, boolean availability) {
		super();
		Id = id;
		this.district = district;
		this.state = state;
		this.availability = availability;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean getAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Branch [Id=" + Id + ", district=" + district + ", state=" + state + ", availability=" + availability
				+ "]";
	}
	

}
