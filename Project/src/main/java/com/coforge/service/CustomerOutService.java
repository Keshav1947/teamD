package com.coforge.service;

import java.util.List;

import com.coforge.model.CustomerOut;

public interface CustomerOutService {
	public CustomerOut createCustomerOut(CustomerOut customerOut);
	public List<CustomerOut> getAllCustomerOut();
	public void deleteCustomerOut(Long id);
	public CustomerOut findOne(Long id);
//	public void updateAvailability(CustomerIn manager, Long id);
	public long days(long id);

}
