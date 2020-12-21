package com.coforge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.model.CustomerIn;

@Repository
public interface CustomerInRepository extends JpaRepository<CustomerIn,Long>{

}
