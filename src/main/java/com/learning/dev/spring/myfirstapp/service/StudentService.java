package com.learning.dev.spring.myfirstapp.service;

import java.util.List;

import com.learning.dev.spring.myfirstapp.entity.Student;


public interface StudentService {
	
	List<Student>findAll();
	Student findById(int stu);
	Student saveStudent(Student students);
	
	void updateStudent(Student stu);
	
	void deleteById(int stu);
	void deleteAllStudent();

}
