package com.coforge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.coforge.model.Manager;
import com.coforge.service.BranchService;
import com.coforge.service.ManagerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/team/d")
public class ManagerController {

	@Autowired
	ManagerService ms;
	
	@Autowired
	BranchService bs;
	
	@GetMapping("/manager")
	public List<Manager> getAllManager(){
		System.out.println(ms.getAllManager());
		return ms.getAllManager();
		
	}
	@GetMapping("/manager/{id}")
	public ResponseEntity<Manager> getManagerById(@PathVariable(value = "id") Long managerId) 
			throws ResourceNotFoundException{
		Manager manager = ms.findOne(managerId);
		return ResponseEntity.ok().body(manager);
	}
	@PostMapping("manager/{id}")
	public Manager createManager(@Valid @RequestBody Manager manager,
			@PathVariable(value ="id") Long branchId) {
		Branch findById = bs.findOne(branchId);
		manager.setBranch(findById);
		System.out.println(ms.createManager(manager));
		return ms.createManager(manager);
	}
	@DeleteMapping("/manager/{id}")
	public Map<String, Boolean> deleteManager(@PathVariable (value = "id") Long managerId)
	throws ResourceNotFoundException{
		ms.deleteManager(managerId);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
}
