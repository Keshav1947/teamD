package com.coforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.model.CardList;
import com.coforge.repository.CardListRepository;

@Service
public class CardListServiceImpl implements CardListService {
	
	@Autowired
	CardListRepository repository;
	
	@Override
	public CardList createCardList(CardList cardlist) {
		// TODO Auto-generated method stub
		return repository.save(cardlist);
	}

	@Override
	public List<CardList> getAllCardList() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public CardList findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void deleteCardList(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Long cardId(Long id) {
		// TODO Auto-generated method stub
		return repository.cardId(id);
	}

	@Override
	public long card(Long cardListId) {
		// TODO Auto-generated method stub
		return repository.card(cardListId);
	}

}
