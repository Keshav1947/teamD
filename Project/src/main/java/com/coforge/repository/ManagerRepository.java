package com.coforge.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coforge.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

		
	@Transactional @Modifying @Query("UPDATE Manager SET phoneno =:phoneno, address =:address,availability =:availability WHERE id =:id")
	void updatemanager(@Param("phoneno")String phoneno,@Param("address")String address,@Param("availability")boolean availability, @Param("id") Long id);

}
