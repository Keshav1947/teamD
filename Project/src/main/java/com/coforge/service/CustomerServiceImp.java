package com.coforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.model.Customer;
import com.coforge.repository.CustomerRepository;
@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	CustomerRepository repository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Customer findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}


	@Override
	public void updateCustomer(Customer customer, Long id) {
		// TODO Auto-generated method stub
		repository.update(customer.getPhoneNo(), customer.getAge(), id);
	}

}
