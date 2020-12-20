package com.coforge.service;

import com.coforge.model.Branch;

import java.util.List;

public interface BranchService {
	public Branch createBranch(Branch branch);
	public List<Branch> getAllBranch();
	public void deleteBranch(Long id);
	public Branch findOne(Long id);
	public void updateBranch(Branch branch, Long id);
	public void updateAvailability(Branch branch, Long id);

}
