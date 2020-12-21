package com.coforge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.exception.ResourceNotFoundException;
import com.coforge.model.Customer;
import com.coforge.model.CustomerIn;
import com.coforge.service.CustomerInService;
import com.coforge.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/team/d")
public class CustomerInController {
	
	@Autowired
	CustomerInService cis;
	
	@Autowired
	CustomerService cs;
	
	@GetMapping("/customerin")
	public List<CustomerIn> getAllCustomerIn(){
		System.out.println(cis.getAllCustomerIn());
		return cis.getAllCustomerIn();
		
	}
	@GetMapping("/customerin/{id}")
	public ResponseEntity<CustomerIn> getCustomerById(@PathVariable(value = "id") Long customerinId) 
			throws ResourceNotFoundException{
		CustomerIn customer = cis.findOne(customerinId);
		
		return ResponseEntity.ok().body(customer);
	}
	@PostMapping("customerin/{id}")
	public CustomerIn createCustomer(@Valid @RequestBody CustomerIn customerIn,
			@PathVariable(value ="id") Long cusId) {
		Customer findById = cs.findOne(cusId);
		customerIn.setCustomer(findById);
		System.out.println(cis.createCustomerIn(customerIn));
		return cis.createCustomerIn(customerIn);
		
	}

}
