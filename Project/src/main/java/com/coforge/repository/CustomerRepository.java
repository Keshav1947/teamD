package com.coforge.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coforge.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	

	@Transactional @Modifying @Query("UPDATE Customer SET phoneNo =:phoneNo, age =:age WHERE id =:id")
	void update(@Param("phoneNo")String phoneNo, @Param("age") int age, @Param("id") Long id);
	
}
