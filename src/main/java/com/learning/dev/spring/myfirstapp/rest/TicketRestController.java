package com.learning.dev.spring.myfirstapp.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dev.spring.myfirstapp.dao.TicketRepository;

import com.learning.dev.spring.myfirstapp.entity.Ticket;

import com.learning.dev.spring.myfirstapp.service.TicketService;

import tools.jackson.databind.json.JsonMapper;

@RestController
@RequestMapping("/api")
public class TicketRestController {

	private JsonMapper jsonMapper;

	private TicketService ticketService;
	
	public TicketRestController(TicketService ticketService,JsonMapper jsonMapper) {
		
		this.ticketService = ticketService;
		
		this.jsonMapper = jsonMapper;

}
	
	@GetMapping("tickets")
	public List<Ticket> getAllTicket() {
		return ticketService.findAll();
	}
	
	@GetMapping("tickets/{ticketsid}")
	public Ticket GetTicketById(@PathVariable long ticketsid) {
		
		Ticket theDes = ticketService.findById(ticketsid);

	        if (theDes == null) {
	            throw new RuntimeException("Ticket id not found - " + ticketsid);
	        }

	        return theDes;
	    }
	
	
	 @DeleteMapping("/tickets/{ticketsid}")
	    public void deleteById(@PathVariable long ticketsid) {
	    	
		 Ticket temptk = ticketService.findById(ticketsid);
			
			if (temptk == null) {
				throw new RuntimeException("Ticket id not found - " + ticketsid);
			}
			
			ticketService.deleteById(ticketsid);
	    }
	 
	 @PutMapping("/tickets") 
	 public Ticket updateAll(@RequestBody Ticket theTicket) {
	    
	     
	     return ticketService.saveTicket(theTicket);
	 }
	 @PatchMapping("/tickets/{ticketsid}")
	     public Ticket updateTicket(@PathVariable long ticketsid, 
	    		@RequestBody Map<String, Object> patchPayLoad) {
		 
		 Ticket tempEmp = ticketService.findById(ticketsid);
		 
		 if (tempEmp == null) {
			  
		    throw new RuntimeException("Ticket id not found - " + ticketsid);
		 }
		    if(patchPayLoad.containsKey("id")) {
		  	  
		  	   throw new RuntimeException("Ticket id cannot be modified. Remove 'id' from request body.");
		    }
		    
		    Ticket pathedEmp  = jsonMapper.updateValue(tempEmp, patchPayLoad);
		  	
		    Ticket dbTicket = ticketService.saveTicket(pathedEmp);
		  	
		 return dbTicket;
	 }
	  
	 @PostMapping("/tickets")
	    public Ticket save(@RequestBody Ticket theEmp) {
	    	
		
		 Ticket resEmp = ticketService.saveTicket(theEmp);
		 
	    	return resEmp;
	    }

	 @GetMapping("/status/{statusid}")
	  public List<Ticket> findByStatus(@PathVariable String statusid) {
		return ticketService.findByStatus(statusid);
	}
	 @DeleteMapping("tickets")
	 public void deleteAllTicket() {
			
		 ticketService.deleteAllTicket();
}
}

