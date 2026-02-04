package com.learning.dev.spring.myfirstapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.dev.spring.myfirstapp.entity.Coustomer;


public interface CoustomerRepository extends JpaRepository<Coustomer, Integer>{

}
