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
import com.learning.dev.spring.myfirstapp.entity.Coustomer;
import com.learning.dev.spring.myfirstapp.service.CoustomerService;
import tools.jackson.databind.json.JsonMapper;

@RestController
@RequestMapping("/api")
public class CoustomerResController {
	
	private CoustomerService coustomerService;
	
	private JsonMapper jsonMapper;
	
	public CoustomerResController(CoustomerService coustomerService,JsonMapper jsonMapper) {
		
		this.coustomerService = coustomerService;
		
		this.jsonMapper = jsonMapper;
			
	}

	@GetMapping("customers")
	public List<Coustomer> getAllCustomers() {
		return coustomerService.findAll();
	}
	
	@GetMapping("customers/{id}")
	public Coustomer GetCustomerById(@PathVariable int id) {
		Coustomer theCoustomer = coustomerService.findById(id);
	
	        if (theCoustomer == null) {
	            throw new RuntimeException("Coustomer id not found - " + id);
	        }

	        return theCoustomer;
	    }
	
	
	 @DeleteMapping("/customers/{id}")
	    public void deleteById(@PathVariable int id) {
	    	
		 Coustomer tempEmp = coustomerService.findById(id);
			
			if (tempEmp == null) {
				throw new RuntimeException("Coustomer id not found - " + id);
			}
			
			coustomerService.deleteById(id);
	    }
	 
	 @PutMapping("/customers/{id}")
	 public Coustomer updateAll(@PathVariable int id, @RequestBody Coustomer customer) {
	                           
	     customer.setId(id);
	     return coustomerService.save(customer);
	 }
	 @PatchMapping("/customers/{id}")
	    public Coustomer updateCoustomer(@PathVariable int id, 
	    		@RequestBody Map<String, Object> patchPayLoad) {
	 	 
	 	 Coustomer tempEmp = coustomerService.findById(id);
	 	 
	 	 if (tempEmp == null) {
	 		  
	 	    throw new RuntimeException("Coustomer id not found - " + id);
	 	 }
	 	    if(patchPayLoad.containsKey("id")) {
	 	  	  
	 	  	  throw new RuntimeException("Coustomer id cannot be modified. Remove 'id' from request body.");
	 	    }
	 	    
	 	  	Coustomer pathedEmp  = jsonMapper.updateValue(tempEmp, patchPayLoad);
	 	  	
	 	  	Coustomer dbCoustomer = coustomerService.save(pathedEmp);
	 	  	
	 				return dbCoustomer;
	 }
	  
	 @PostMapping("/customers")
	    public Coustomer save(@RequestBody Coustomer theEmp) {
	    	
	 	 theEmp.setId(0);
	 	 Coustomer resEmp = coustomerService.save(theEmp);
	 	 
	     	return resEmp;
	    }

}


