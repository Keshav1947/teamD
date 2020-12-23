package com.coforge.service;

import java.util.List;

import com.coforge.model.Manager;

public interface ManagerService {
	public Manager createManager(Manager manager);
	public List<Manager> getAllManager();
	public void deleteManager(Long id);
	public Manager findOne(Long id);
	public void updateManager(Manager manager,Long id);

}
