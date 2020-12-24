package com.coforge.service;

import java.util.List;

import com.coforge.model.CustomerIn;

public interface CustomerInService {
	public CustomerIn createCustomerIn(CustomerIn customerIn);
	public List<CustomerIn> getAllCustomerIn();
	public CustomerIn findOne(Long id);
	public String datein(Long customerId);
	


}
