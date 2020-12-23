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
import com.coforge.service.CardService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/team/d")
public class CardController {

	@Autowired
	CardService cs;
	@GetMapping("/card")
	public List<Card> getAllBranch(){
		System.out.println(cs.getAllCard());
		return cs.getAllCard();
		
	}
	@GetMapping("/card/{id}")
	public ResponseEntity<Card> getCardById(@PathVariable(value = "id") Long id) 
			throws ResourceNotFoundException{
		Card card = cs.findOne(id);
		return ResponseEntity.ok().body(card);
	}
	@PostMapping("card")
	public Card createCard(@Valid @RequestBody Card card) {
		System.out.println(cs.createCard(card));
		return cs.createCard(card);
		
	}
	@PutMapping("/card/{id}")
	public ResponseEntity<Card> updateCard(@PathVariable(value="id") Long id,
			@Valid @RequestBody Card cardDetails) throws ResourceNotFoundException{
		Card card= cs.findOne(id);
		card.setAmount(cardDetails.getAmount());
		card.setAvailability(cardDetails.isAvailability());
		card.setDiscount(cardDetails.getDiscount());
		card.setDuration(cardDetails.getDuration());
        card.setName(cardDetails.getName());		
		final Card updatedCard = cs.createCard(card);
		return ResponseEntity.ok(updatedCard);
	}
//	@PutMapping("/card/availability/{id}")
//	public ResponseEntity<Card> updateCardAvailability(@PathVariable(value="id") Long id,
//			@Valid @RequestBody Branch branchDetails) throws ResourceNotFoundException{
//		Card card = cs.findOne(id);
//		card.setAvailability(branchDetails.getAvailability());
//		final Card updatedCard = cs.createCard(card);
//		return ResponseEntity.ok(updatedCard);
//	}
	@DeleteMapping("/card/{id}")
	public Map<String, Boolean> deleteCard(@PathVariable (value = "id") Long id)
	throws ResourceNotFoundException{
//	Card card = cs.findOne(id);
		cs.deleteCard(id);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
	
}
