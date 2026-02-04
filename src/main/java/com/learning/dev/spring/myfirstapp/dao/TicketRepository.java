package com.learning.dev.spring.myfirstapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.dev.spring.myfirstapp.entity.Ticket;


public interface TicketRepository extends JpaRepository<Ticket,Long>{

	List<Ticket> findById(String status);

	

//	List<Ticket> findById(String status);

	

}
