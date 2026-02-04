package com.learning.dev.spring.myfirstapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.learning.dev.spring.myfirstapp.dao.DepartmentsRepository;

import com.learning.dev.spring.myfirstapp.entity.Departments;

import jakarta.transaction.Transactional;
import tools.jackson.databind.json.JsonMapper;

@Service
public class DepartmentsServicemlpl implements DepartmentsService{

	
	 private DepartmentsRepository departmentsRepository;
	
	 private JsonMapper jsonMapper;
	
	 @Autowired
	 public DepartmentsServicemlpl(DepartmentsRepository departmentsRepository,JsonMapper jsonMapper) {
		
		this.departmentsRepository = departmentsRepository;
		
		this.jsonMapper = jsonMapper;
	}

	 @Override
	 @Transactional
	 public Departments saveDepartments(Departments departments) {
		
		return departmentsRepository.save(departments);
	 }

	 @Override
	 public void updateDepartments(Departments departments) {
		
		 departmentsRepository.save(departments);
		
	 }

	
	 @Override
	 public Departments findById(long Departmentsid) {
			
		    Optional<Departments>result = departmentsRepository.findById(Departmentsid);
			
			Departments departmentsRepository = null;
			if(result.isPresent()) {
				departmentsRepository = result.get();
			}
			else {
				//System.out.println("Did not find Departments id"+id);
				throw new RuntimeException("Did not find Departments id - " + Departmentsid);
			}
			return departmentsRepository;
		}
	 

	 @Override
	 public List<Departments> findAll() {
		
		return departmentsRepository.findAll();
	 }

	 @Override
	 @Transactional
	 public void deleteById(long Departmentsid) {
		
		 departmentsRepository.deleteById(Departmentsid);
		
	 }
	 
}