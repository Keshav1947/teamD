package com.coforge.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.model.Customer;
import com.coforge.model.CustomerOut;
import com.coforge.repository.CustomerOutRepository;

@Service
public class CustomerOutServiceImp implements CustomerOutService{

	@Autowired
	CustomerOutRepository repo;
	

	@Override
	public CustomerOut createCustomerOut(CustomerOut customerOut) {
		// TODO Auto-generated method stub
		return repo.save(customerOut);
	}

	@Override
	public List<CustomerOut> getAllCustomerOut() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteCustomerOut(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public CustomerOut findOne(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	@Override
	public long days(long id) {
		// TODO Auto-generated method stub
		
		return repo.days(id);
	}

}
