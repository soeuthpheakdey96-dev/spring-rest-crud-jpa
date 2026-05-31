package com.learning.dev.spring.myfirstapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.dev.spring.myfirstapp.entity.User;

public interface UserRepoSitory extends JpaRepository<User,Integer>{

}
