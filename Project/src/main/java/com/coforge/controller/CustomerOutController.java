package com.coforge.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.exception.ResourceNotFoundException;
import com.coforge.model.Customer;
import com.coforge.model.CustomerIn;
import com.coforge.model.CustomerOut;
import com.coforge.service.CustomerInService;
import com.coforge.service.CustomerOutService;
import com.coforge.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/team/d")
public class CustomerOutController {

	@Autowired
	CustomerService cs;
	
	@Autowired
	CustomerInService ci;
	
	@Autowired
	CustomerOutService couts;
	
	@GetMapping("/customerout")
	public List<CustomerOut> getAllCustomerOut(){
		System.out.println(couts.getAllCustomerOut());
		return couts.getAllCustomerOut();
		
	}
	@GetMapping("/customerout/{id}")
	public ResponseEntity<CustomerOut> getManagerById(@PathVariable(value = "id") Long customerOutId) 
			throws ResourceNotFoundException{
		CustomerOut customerOut = couts.findOne(customerOutId);
		return ResponseEntity.ok().body(customerOut);
	}
	
	
	
	@PostMapping("customerout/{id}/{inid}")
	public CustomerOut createCustomerOut(@Valid @RequestBody CustomerOut customerOut,
			@PathVariable(value ="id") Long customerId, @PathVariable(value ="inid") Long cid) {
		Customer findById = cs.findOne(customerId);
		
		CustomerIn find = ci.findOne(cid);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
		
		try {
			 System.out.println ("Day1: " + find);
		    LocalDate date1 = LocalDate.parse(find.getDatein(), dtf);
		    System.out.println ("Day1: " + date1);
		    LocalDate date2 = LocalDate.parse(customerOut.getDateout(), dtf);
		    System.out.println ("Day2: " + date2);
		    long days = ChronoUnit.DAYS.between(date1, date2);
		    System.out.println ("Days: " + days);
		    customerOut.setTotalDays(days);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		customerOut.setCustomer(findById);
		
		
		System.out.println(couts.createCustomerOut(customerOut));
		return couts.createCustomerOut(customerOut);
	}
	
	@DeleteMapping("/customerout/{id}")
	public Map<String, Boolean> deleteCustomerOut(@PathVariable (value = "id") Long customerOutId)
	throws ResourceNotFoundException{
		couts.deleteCustomerOut(customerOutId);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
}
