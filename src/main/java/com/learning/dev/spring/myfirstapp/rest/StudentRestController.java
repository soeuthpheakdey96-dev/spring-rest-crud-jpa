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



import com.learning.dev.spring.myfirstapp.entity.Student;
import com.learning.dev.spring.myfirstapp.service.StudentService;

import tools.jackson.databind.json.JsonMapper;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	 private StudentService studentService;
	 
	 private JsonMapper jsonMapper;
	 
	 public StudentRestController(StudentService studentService,JsonMapper jsonMapper) {
		 
		 
		 this.studentService = studentService;
		 
		 this.jsonMapper = jsonMapper;
	 }

		@GetMapping("student")
		public List<Student> getAllStudent() {
			return studentService.findAll();
		}
		
		@GetMapping("student/{id}")
		public Student GetDepartmentsById(@PathVariable int id) {
			Student theDes = studentService.findById(id);

		        if (theDes == null) {
		            throw new RuntimeException("Student id not found - " + id);
		        }

		        return theDes;
		    }
		
		
		 @DeleteMapping("/student/{id}")
		    public void deleteById(@PathVariable int id) {
		    	
			 Student tempDpt = studentService.findById(id);
				
				if (tempDpt == null) {
					throw new RuntimeException("Student id not found - " + id);
				}
				
				studentService.deleteById(id);
		    }
		 
		 @PutMapping("/student/{id}")
		 public Student updateAll(@PathVariable int id,
		                           @RequestBody Student students) {
			 students.setId(id);
		     return studentService.saveStudent(students);
		 }
		 @PatchMapping("/student/{id}")
		     public Student updateStudent(@PathVariable int id, 
		    		@RequestBody Map<String, Object> patchPayLoad) {
			 
			 Student tempStu = studentService.findById(id);
			 
			 if (tempStu == null) {
				  
			    throw new RuntimeException("Student id not found - " + id);
			 }
			    if(patchPayLoad.containsKey("id")) {
			  	  
			  	   throw new RuntimeException("Student id cannot be modified. Remove 'id' from request body.");
			    }
			    
			    Student pathedEmp  = jsonMapper.updateValue(tempStu, patchPayLoad);
			  	
			    Student dbStu = studentService.saveStudent(pathedEmp);
			  	
			 return dbStu;
		 }
		  
		 @PostMapping("/student")
		    public Student save(@RequestBody Student theStu) {
		    	
			
			 Student resStu = studentService.saveStudent(theStu);
			 
		    	return resStu;
		    }
		 @DeleteMapping("/student")
		 public void deleteAllStudent() {
				
			 studentService.deleteAllStudent();
	}
	 
}
