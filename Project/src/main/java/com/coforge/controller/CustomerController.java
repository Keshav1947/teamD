package com.coforge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.exception.ResourceNotFoundException;
import com.coforge.model.Branch;
import com.coforge.model.Customer;
import com.coforge.service.BranchService;
import com.coforge.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/team/d")
public class CustomerController {

	@Autowired
	CustomerService cs;
	
	@Autowired
	BranchService bs;
	
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer(){
		System.out.println(cs.getAllCustomer());
		return cs.getAllCustomer();
		
	}
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId) 
			throws ResourceNotFoundException{
		Customer customer = cs.findOne(customerId);
		return ResponseEntity.ok().body(customer);
	}
	@PostMapping("customers/{id}")
	public Customer createCustomer(@Valid @RequestBody Customer customer,
			@PathVariable(value ="id") Long branchId) {
		Branch findById = bs.findOne(branchId);
		customer.setBranch(findById);
		System.out.println(cs.createCustomer(customer));
		return cs.createCustomer(customer);
		
	}
	
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value="id") Long customerId,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException{
		Customer customer = cs.findOne(customerId );
		customer.setAge(customerDetails.getAge());
		customer.setPhoneNo(customerDetails.getPhoneNo());
		final Customer updatedCustomer = cs.createCustomer(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	
	@DeleteMapping("/customers/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable (value = "id") Long customerId)
	throws ResourceNotFoundException{
		cs.deleteCustomer(customerId);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
	

	
}
