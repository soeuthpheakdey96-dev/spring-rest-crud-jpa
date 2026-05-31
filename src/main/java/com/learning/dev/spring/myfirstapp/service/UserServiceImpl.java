package com.learning.dev.spring.myfirstapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.learning.dev.spring.myfirstapp.dao.UserRepoSitory;
import com.learning.dev.spring.myfirstapp.entity.User;

import jakarta.transaction.Transactional;
import tools.jackson.databind.json.JsonMapper;

@Service
public class UserServiceImpl implements UserService{

		private UserRepoSitory userRepoSitory;
		private JsonMapper jsonMapper;
		
		@Autowired
		public  UserServiceImpl(UserRepoSitory userRepoSitory, JsonMapper jsonMapper) {
		
			this.userRepoSitory = userRepoSitory;
			this.jsonMapper = jsonMapper;
		}	
	@Transactional
	@Override
	
	public User saveUser(User user) {
		
		return userRepoSitory.save(user);
	}

	@Override
	public void updateTicket(User user) {
		
		userRepoSitory.save(user);
		
	}

	@Override
	@Transactional
	public User findById(int userid) {
		Optional<User>result = userRepoSitory.findById(userid);
		
		User user;
		if(result.isPresent()) {
			user=result.get();
		}else {
			throw new RuntimeException("Did not fine by id-" + userid);
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		
		return userRepoSitory.findAll();
	}
	@Transactional
	@Override
	
	public void deleteById(int userid) {
		Optional<User>result = userRepoSitory.findById(userid);
		
		if(result.isPresent()) {
			userRepoSitory.deleteById(userid);
		}else {
			throw new RuntimeException("Did not fine by id-" + userid);
		}		
	}

	@Override
	public void deleteAllUser() {
		
		userRepoSitory.deleteAll();
		
	}

}
