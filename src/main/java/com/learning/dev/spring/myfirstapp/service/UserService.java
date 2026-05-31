package com.learning.dev.spring.myfirstapp.service;

import java.util.List;


import com.learning.dev.spring.myfirstapp.entity.User;

public interface UserService {
	
	User saveUser(User user);
	
	void updateTicket(User users);
	
	User findById(int usersid);
	List<User>findAll();
	void deleteById(int usersid);
	void deleteAllUser();

}
