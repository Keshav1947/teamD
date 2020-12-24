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
import com.coforge.model.Card;
import com.coforge.model.CardList;
import com.coforge.model.Customer;
import com.coforge.service.BranchService;
import com.coforge.service.CardListService;
import com.coforge.service.CardService;
import com.coforge.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/team/d")
public class CardListController {

     @Autowired
     CustomerService cts;
     
	@Autowired
	CardListService cls;
	
	@Autowired
	CardService cs;
	
	@GetMapping("/cardlist")
	public List<CardList> getAllCardList(){
		System.out.println(cls.getAllCardList());
		return cls.getAllCardList();
	}
	@GetMapping("/cardlist/{id}")
	public ResponseEntity<CardList> getCardListById(@PathVariable(value = "id") Long id) 
			throws ResourceNotFoundException{
		CardList cardlist = cls.findOne(id);
		return ResponseEntity.ok().body(cardlist);
	}
	
	@PostMapping("cardlist/{id}/{cid}")
	public CardList createCardList(@Valid @RequestBody CardList cardlist,
			@PathVariable(value ="id") Long CardId,@PathVariable(value ="cid") Long CustomerId) {
		Card findById = cs.findOne(CardId);
		Customer find = cts.findOne(CustomerId);
		cardlist.setCard(findById);
		cardlist.setCustomer(find);
		System.out.println(cls.createCardList(cardlist));
		return cls.createCardList(cardlist);	
	}
	

	@DeleteMapping("/cardlist/{id}")
	public Map<String, Boolean> deleteCardList(@PathVariable (value = "id") Long id)
	throws ResourceNotFoundException{
		cls.deleteCardList(id);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
	

	
}

