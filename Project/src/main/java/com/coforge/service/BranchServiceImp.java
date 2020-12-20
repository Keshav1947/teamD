package com.coforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.model.Branch;
import com.coforge.repository.BranchRepository;
@Service
public class BranchServiceImp implements BranchService{

	@Autowired
	BranchRepository repository;
	
	@Override
	public Branch createBranch(Branch branch) {
		// TODO Auto-generated method stub
		return repository.save(branch);
	}

	@Override
	public List<Branch> getAllBranch() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteBranch(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Branch findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	@Override
	public void updateBranch(Branch branch, Long id) {
		// TODO Auto-generated method stub
		repository.update(branch.getDistrict(),branch.getState(),id);
	}

	@Override
	public void updateAvailability(Branch branch, Long id) {
		// TODO Auto-generated method stub
		repository.updateavailability(branch.getAvailability(),id);
		
	}

}