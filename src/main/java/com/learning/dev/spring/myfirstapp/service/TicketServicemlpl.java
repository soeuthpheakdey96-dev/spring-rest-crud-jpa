package com.learning.dev.spring.myfirstapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dev.spring.myfirstapp.dao.TicketRepository;

import com.learning.dev.spring.myfirstapp.entity.Ticket;

import tools.jackson.databind.json.JsonMapper;

@Service
public class TicketServicemlpl implements TicketService{

	private TicketRepository ticketRepository;
	private JsonMapper jsonMapper;
	
	@Autowired
	public TicketServicemlpl(TicketRepository ticketRepository, JsonMapper jsonMapper) {
		
		this.ticketRepository = ticketRepository;
		this.jsonMapper = jsonMapper;
	}
	@Override
	public Ticket saveTicket(Ticket tickets) {
		
		return ticketRepository.save(tickets);
	}

	@Override
	public void updateTicket(Ticket tickets) {
		
		ticketRepository.save(tickets);
	}

	@Override
	public Ticket findById(long ticketsid) {
		Optional<Ticket>result = ticketRepository.findById(ticketsid);
		
		Ticket ticketRepository = null;
		if (result.isPresent()) {
			ticketRepository = result.get();
		}else {
			throw new RuntimeException("Did not find Ticket id - " + ticketsid);
		}
		return ticketRepository;
	}

	@Override
	public List<Ticket> findAll() {
		
		return ticketRepository.findAll();
	}

	@Override
	public void deleteById(long ticketsid) {
		
		ticketRepository.deleteById(ticketsid);
	}

	@Override
	public void deleteAllTicket() {
		
		ticketRepository.deleteAll();
		
	}

//	
//	@Override
//	public List<Ticket> findByStatus() {
//		
//		return ticketRepository.findByStatus();
//	}
//	@Override
//	public List<Ticket> getActiveTicket() {
//		
//		return ticketRepository.findByStatus();
//	}
	@Override
	public List<Ticket> findByStatus(String status) {
		
		return ticketRepository.findById(status);
	}

	
	

	
}
