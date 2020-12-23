package com.coforge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coforge.model.CardList;

@Service
public interface CardListService {
	public CardList createCardList(CardList cardlist);
	public List<CardList> getAllCardList();
	public CardList findOne(Long id);
	public void deleteCardList(Long id);
	
}
