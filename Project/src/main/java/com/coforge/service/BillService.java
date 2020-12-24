package com.coforge.service;

import java.util.List;

import com.coforge.model.Bill;

public interface BillService {
	public Bill createBill(Bill bill);
	public List<Bill> getAllBill();
	public void deleteBill(Long id);
	public Bill findOne(Long id);
	
}
