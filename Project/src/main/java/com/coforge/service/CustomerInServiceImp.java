package com.coforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.model.CustomerIn;
import com.coforge.repository.CustomerInRepository;

@Service
public class CustomerInServiceImp implements CustomerInService{

	@Autowired
	CustomerInRepository repository;
	
	@Override
	public CustomerIn createCustomerIn(CustomerIn customerIn) {
		// TODO Auto-generated method stub
		return repository.save(customerIn);
	}

	@Override
	public List<CustomerIn> getAllCustomerIn() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public CustomerIn findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

}
