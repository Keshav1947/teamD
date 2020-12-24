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
import com.coforge.model.Bill;
import com.coforge.model.Card;
import com.coforge.model.CardList;
import com.coforge.model.Customer;
import com.coforge.model.CustomerIn;
import com.coforge.model.CustomerOut;
import com.coforge.service.BillServiceImp;
import com.coforge.service.CardListService;
import com.coforge.service.CardService;
import com.coforge.service.CustomerOutService;
import com.coforge.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/team/d")
public class BillController {
	
	@Autowired
	BillServiceImp bi;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	CardService cds;
	
	@Autowired
	CardListService cls;
	
	@Autowired
	CustomerOutService co;
	
	
	@GetMapping("/bill")
	public List<Bill> getAllBill(){
		System.out.println(bi.getAllBill());
		return bi.getAllBill();
		
	}
	@GetMapping("/bill/{id}")
	public ResponseEntity<Bill> getBillById(@PathVariable(value = "id") Long billId			) 
			throws ResourceNotFoundException{
		Bill bill = bi.findOne(billId);
		return ResponseEntity.ok().body(bill);
	}
	
	@PostMapping("bill/{id}")
	public Bill createBill(@Valid @RequestBody Bill bill,
			@PathVariable(value ="id") Long CustomerId) {
		Customer customer = cs.findOne(CustomerId);
		bill.setCustomer(customer);
	
//		CustomerOut cout = co.findOne(coutId);
		
		long day = co.days(CustomerId);
//		System.out.println(day);
		
		long amount = 1000*(day);
		
		bill.setPaidamount(amount);
		
		Long cardListId = cls.cardId(CustomerId);
//		System.out.println(cardListId);
//		CardList cl = cls.findOne(cout.getId());
//		long cardId = cds.discount(cardListId);
		
		Long cardId = cls.card(cardListId);
		System.out.println(cardId);
		Card c = cds.findOne(cardId);
		
		bill.setDiscount(c.getDiscount());
		long pamount = ((100-c.getDiscount())*amount)/100;
//		System.out.println(pamount);
		bill.setBillamount(pamount);
		
		
		
		System.out.println(bi.createBill(bill));
		return bi.createBill(bill);
		
	}
	
	@DeleteMapping("/bill/{id}")
	public Map<String, Boolean> deleteBill(@PathVariable (value = "id") Long billId)
	throws ResourceNotFoundException{
		bi.deleteBill(billId);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}

}
