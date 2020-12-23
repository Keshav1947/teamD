package com.coforge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coforge.model.Card;
@Service
public interface CardService {
	public Card createCard(Card card);
	public List<Card> getAllCard();
	public void deleteCard(Long id);
	public Card findOne(Long id);
	public void updateCard(Card card,Long id);
}
