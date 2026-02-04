package com.learning.dev.spring.myfirstapp.service;

import java.util.List;


import com.learning.dev.spring.myfirstapp.entity.Ticket;



public interface TicketService {
	
	Ticket saveTicket(Ticket tickets);
	
	void updateTicket(Ticket tickets);
	
	Ticket findById(long ticketsid);
	List<Ticket> findAll();
	void deleteById(long ticketsid);
	void deleteAllTicket();
	
	List<Ticket> findByStatus(String status);
	//List<Ticket> findById(String status);

	
}
