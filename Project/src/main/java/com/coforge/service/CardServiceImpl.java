package com.coforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.model.Card;
import com.coforge.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService{
	
	@Autowired
	CardRepository crepository;


	@Override
	public Card createCard (Card card) {
		// TODO Auto-generated method stub
		return crepository.save(card);
	}

	@Override
	public List<Card> getAllCard() {
		// TODO Auto-generated method stub
		return crepository.findAll();
	}

	@Override
	public void deleteCard(Long id) {
		// TODO Auto-generated method stub
		crepository.deleteById(id);
	}

	@Override
	public Card findOne(Long id) {
		// TODO Auto-generated method stub
		return crepository.getOne(id);
	}

	@Override
	public void updateCard(Card card, Long id) {
		// TODO Auto-generated method stub
		crepository.update(card.isAvailability(),card.getAmount(),card.getDiscount(),card.getDuration(),card.getGroup_limit(), id);
		
	}

//	@Override
//	public long discount(Long cardListId) {
//		// TODO Auto-generated method stub
//		return crepository.dis(cardListId);
//	}

//	@Override
//	public Card updateCard(Card card, Long id) {
//		// TODO Auto-generated method stub
//		card crepository.save(card);
//	}


}
