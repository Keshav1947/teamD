package com.coforge.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coforge.model.CustomerIn;

@Repository
public interface CustomerInRepository extends JpaRepository<CustomerIn,Long>{

	@Transactional @Query("SELECT datein FROM CustomerIn  where customer_id = :customer_id")
	String datein(@Param("customer_id")Long customer_id);

}
