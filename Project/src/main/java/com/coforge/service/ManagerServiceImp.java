package com.coforge.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.model.Branch;
import com.coforge.model.Manager;
import com.coforge.repository.BranchRepository;
import com.coforge.repository.ManagerRepository;
@Service
public class ManagerServiceImp implements ManagerService{

	@Autowired
	ManagerRepository repo;
	
	@Override
	public Manager createManager(Manager manager) {
		return repo.save(manager);
	}

	@Override
	public List<Manager> getAllManager() {
		return repo.findAll();
	}

	@Override
	public void deleteManager(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Manager findOne(Long id) {
		return repo.getOne(id);
	}

	@Override
	public void updateAvailability(Manager manager, Long id) {
		repo.updateavailability(manager.getAvailability(),id);
		
	}

}
