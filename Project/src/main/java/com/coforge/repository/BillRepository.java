package com.coforge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.model.Bill;
@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{

}
