package com.coforge.service;

import com.coforge.model.Customer;

import java.util.List;

public interface CustomerService {
	public Customer createCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public void deleteCustomer(Long id);
	public Customer findOne(Long id);
	public void updateCustomer(Customer customer, Long id);

}
