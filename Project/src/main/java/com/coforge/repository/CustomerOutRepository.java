package com.coforge.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coforge.model.CustomerOut;

@Repository
public interface CustomerOutRepository extends JpaRepository<CustomerOut, Long> {

//		
//	@Transactional @Modifying @Query("UPDATE Branch SET availability =:availability WHERE id =:id")
//	void updateavailability(@Param("availability")boolean availability, @Param("id") Long id);
	
	@Transactional @Query("SELECT totalDays FROM CustomerOut  where customer_id = :customer_id")
	long days(@Param("customer_id") long customer_id);

}
