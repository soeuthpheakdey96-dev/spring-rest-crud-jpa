package com.learning.dev.spring.myfirstapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.learning.dev.spring.myfirstapp.entity.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments,Long> {

}
