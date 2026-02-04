package com.learning.dev.spring.myfirstapp.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.learning.dev.spring.myfirstapp.entity.Departments;

import com.learning.dev.spring.myfirstapp.service.DepartmentsService;

import tools.jackson.databind.json.JsonMapper;

@RestController
@RequestMapping("/api")
public class DepartmentsResController {

	
	private JsonMapper jsonMapper;

	private DepartmentsService departmentsService;
	
	public DepartmentsResController(DepartmentsService departmentsService,JsonMapper jsonMapper) {
		
		this.departmentsService = departmentsService;
		
		this.jsonMapper = jsonMapper;

}
	
	@GetMapping("departments")
	public List<Departments> getAllDepartments() {
		return departmentsService.findAll();
	}
	
	@GetMapping("departments/{id}")
	public Departments GetDepartmentsById(@PathVariable long id) {
		Departments theDes = departmentsService.findById(id);

	        if (theDes == null) {
	            throw new RuntimeException("Departments id not found - " + id);
	        }

	        return theDes;
	    }
	
	
	 @DeleteMapping("/departments/{id}")
	    public void deleteById(@PathVariable long id) {
	    	
		 Departments tempDpt = departmentsService.findById(id);
			
			if (tempDpt == null) {
				throw new RuntimeException("Coustomer id not found - " + id);
			}
			
			departmentsService.deleteById(id);
	    }
	 
	 @PutMapping("/departments/{id}")
	 public Departments updateAll(@PathVariable long id,
	                           @RequestBody Departments departments) {
		 departments.setDepartment_id(id);
	     return departmentsService.saveDepartments(departments);
	 }
	 @PatchMapping("/departments/{id}")
	     public Departments updateDepartments(@PathVariable long id, 
	    		@RequestBody Map<String, Object> patchPayLoad) {
		 
		 Departments tempEmp = departmentsService.findById(id);
		 
		 if (tempEmp == null) {
			  
		    throw new RuntimeException("Departments id not found - " + id);
		 }
		    if(patchPayLoad.containsKey("id")) {
		  	  
		  	   throw new RuntimeException("Departments id cannot be modified. Remove 'id' from request body.");
		    }
		    
		 Departments pathedEmp  = jsonMapper.updateValue(tempEmp, patchPayLoad);
		  	
		 Departments dbDepartments = departmentsService.saveDepartments(pathedEmp);
		  	
		 return dbDepartments;
	 }
	  
	 @PostMapping("/departments")
	    public Departments save(@RequestBody Departments theEmp) {
	    	
		
		 Departments resEmp = departmentsService.saveDepartments(theEmp);
		 
	    	return resEmp;
	    }

}

