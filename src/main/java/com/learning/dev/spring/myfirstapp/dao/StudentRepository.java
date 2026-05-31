package com.learning.dev.spring.myfirstapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.dev.spring.myfirstapp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	

}
