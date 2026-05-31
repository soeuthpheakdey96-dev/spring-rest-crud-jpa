package com.learning.dev.spring.myfirstapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dev.spring.myfirstapp.dao.StudentRepository;

import com.learning.dev.spring.myfirstapp.entity.Student;

import tools.jackson.databind.json.JsonMapper;

@Service
public class StudentServicemlpl implements StudentService{
	
	 private StudentRepository studentRepository;
	 private JsonMapper jsonMapper;
	 
	 @Autowired
	 
	 public StudentServicemlpl(StudentRepository studentRepository, JsonMapper jsonMapper) {
	 
	 this.jsonMapper = jsonMapper;
	 this.studentRepository = studentRepository;
	 }

	@Override
	public List<Student> findAll() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int stu) {
	    Optional<Student>result = studentRepository.findById(stu);
		
	    Student studentRepository = null;
				if(result.isPresent()) {
					studentRepository = result.get();
				}
				else {
					//System.out.println("Did not find Student id"+id);
					throw new RuntimeException("Did not find Student id - " + stu);
				}
				return studentRepository;
			}

	@Override
	public Student saveStudent(Student students) {
		
		return studentRepository.save(students);
	}

	@Override
	public void updateStudent(Student stu) {
		
		studentRepository.save(stu);
		
	}

	@Override
	public void deleteById(int stu) {
		
		studentRepository.deleteById(stu);
		
	}

	@Override
	public void deleteAllStudent() {
		
		studentRepository.deleteAll();
		
		
	}

}
