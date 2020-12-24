package com.coforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.model.Bill;
import com.coforge.repository.BillRepository;
@Service
public class BillServiceImp implements BillService{

	@Autowired
	BillRepository repository;
	@Override
	public Bill createBill(Bill bill) {
		// TODO Auto-generated method stub
		return repository.save(bill);
	}

	@Override
	public List<Bill> getAllBill() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteBill(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Bill findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

}
