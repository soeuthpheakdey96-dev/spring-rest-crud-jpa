package com.learning.dev.spring.myfirstapp.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;


import com.learning.dev.spring.myfirstapp.entity.User;
import com.learning.dev.spring.myfirstapp.service.UserService;

import tools.jackson.databind.json.JsonMapper;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	private JsonMapper jsonMapper;
	
	
	public UserRestController(UserService userService, JsonMapper jsonMapper) {
		
		this.userService = userService;
		
		this.jsonMapper = jsonMapper;	
	}
	@GetMapping("/users")
	public List<User>findAll(){
		
		return userService.findAll();	
	}
	@GetMapping("/users/{id}")
	public User GetUserByid(@PathVariable int id) {
		
		User theuser = userService.findById(id);
		
		if(theuser==null) {
			
			throw new RuntimeException("Did not find this id-" + id);
		}
		
		return theuser;	
	}
	
	@PostMapping("/users")
	public User SaveUser(@RequestBody User user) {
		
		User theuser = userService.saveUser(user);
		
		return theuser;	
	}
	@PatchMapping("users/{id}")
	public User UpdateUser(@PathVariable int id,
			@RequestBody Map<String, Object> patchPayLoad) 
	throws JsonMappingException{
		
		User theuser = userService.findById(id);
	
		if(theuser==null) {
			throw new RuntimeException("User id is not found - " + id);
		}
		return jsonMapper.updateValue(theuser, patchPayLoad);
		
	}
	 
	 @PutMapping("/users") 
	 public User updateAll(@RequestBody User user) {
	    
	     
	     return userService.saveUser(user);
	 }
	 @DeleteMapping("/users")
	 public void deleteAllUser() {
			
		 userService.deleteAllUser();
}

	 @DeleteMapping("/users/{id}")
	    public void deleteById(@PathVariable int id) {
	    	
		 User tepuser = userService.findById(id);
			
			if (tepuser == null) {
				throw new RuntimeException("Ticket id not found - " + id);
			}
			
			userService.deleteById(id);
	    }
	 }

