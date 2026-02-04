package com.learning.dev.spring.myfirstapp.service;

import java.util.List;

import com.learning.dev.spring.myfirstapp.entity.Departments;

public interface DepartmentsService {

	
	 Departments saveDepartments(Departments departments);
//	 List<Departments> fetchDepartmentsList();
	 void updateDepartments(Departments departments);
	 //void deleteDepartmentsById(Long id);
	 Departments findById(long Departmentsid);
	 List<Departments> findAll();
		// TODO Auto-generated method stub
	 void deleteById(long Departmentsid);
	
	
	 }

