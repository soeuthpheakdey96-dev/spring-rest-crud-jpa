package com.learning.dev.spring.myfirstapp.service;

import java.util.List;

import com.learning.dev.spring.myfirstapp.entity.Coustomer;


public interface CoustomerService {
	
	
	
	Coustomer findById(int theEmp);
	
	Coustomer save(Coustomer emp);
	
	void deleteById(int theId);

	List<Coustomer> findAll();

}
