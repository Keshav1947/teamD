package com.coforge.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coforge.model.Card;

public interface CardRepository  extends JpaRepository<Card, Long>{ 
	
	

	@Transactional @Modifying @Query("UPDATE Card SET availability =:availability,amount =:amount,discount =:discount,duration =:duration,group_limit =:group_limit  WHERE id =:id")
	void update(@Param("availability")boolean availability, 
		           	@Param(	"amount")Long amount,
		           	@Param(	"discount")Long discount,
		           	@Param("duration")Long duration,
		           	@Param("group_limit")int group_limit,
			        @Param("id") Long id);

}
