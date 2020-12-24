package com.coforge.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coforge.model.CardList;

public interface CardListRepository extends JpaRepository<CardList, Long>{
	

	@Transactional @Query("SELECT id FROM CardList where customer_id = :customer_id")
	Long cardId(@Param("customer_id") Long customer_id);
	
	@Transactional @Query("SELECT card.id FROM CardList where id = :id")
	long card(@Param("id") Long id);

}
