package com.coforge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.exception.ResourceNotFoundException;
import com.coforge.model.Branch;
import com.coforge.service.BranchService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/team/d")
public class BranchController {

	@Autowired
	BranchService bs;
	@GetMapping("/branchs")
	public List<Branch> getAllBranch(){
		System.out.println(bs.getAllBranch());
		return bs.getAllBranch();
		
	}
	@GetMapping("/branchs/{id}")
	public ResponseEntity<Branch> getBranchById(@PathVariable(value = "id") Long branchId) 
			throws ResourceNotFoundException{
		Branch branch = bs.findOne(branchId);
		return ResponseEntity.ok().body(branch);
	}
	@PostMapping("branchs")
	public Branch createBranch(@Valid @RequestBody Branch branch) {
		System.out.println(bs.createBranch(branch));
		return bs.createBranch(branch);
		
	}
	@PutMapping("/branchs/{id}")
	public ResponseEntity<Branch> updateBranch(@PathVariable(value="id") Long branchId,
			@Valid @RequestBody Branch branchDetails) throws ResourceNotFoundException{
		Branch branch = bs.findOne(branchId);
		branch.setState(branchDetails.getState());
		branch.setDistrict(branchDetails.getDistrict());
		final Branch updatedBranch = bs.createBranch(branch);
		return ResponseEntity.ok(updatedBranch);
	}
	@PutMapping("/branchs/availability/{id}")
	public ResponseEntity<Branch> updateBranchAvailability(@PathVariable(value="id") Long branchId,
			@Valid @RequestBody Branch branchDetails) throws ResourceNotFoundException{
		Branch branch = bs.findOne(branchId);
		branch.setAvailability(branchDetails.getAvailability());
		final Branch updatedBranch = bs.createBranch(branch);
		return ResponseEntity.ok(updatedBranch);
	}
	@DeleteMapping("/branchs/{id}")
	public Map<String, Boolean> deleteBranch(@PathVariable (value = "id") Long branchId)
	throws ResourceNotFoundException{
//		Branch branch = bs.findOne(branchId);
		bs.deleteBranch(branchId);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
	
}