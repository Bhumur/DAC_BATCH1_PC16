package com.bhumur.Ticket.controller;


import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhumur.Ticket.dto.TicketDTO;
import com.bhumur.Ticket.entity.Ticket;
import com.bhumur.Ticket.service.TicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Ticket")
public class TicketController{
	
	@Autowired
	TicketService ticketService;

	@PostMapping("/create")
	public ResponseEntity<String> createTicket(@Valid @RequestBody Ticket ticket) {
		System.out.println("create");
		TicketDTO t =  ticketService.addTicket(ticket);
		if(t==null) {
			return new ResponseEntity<String>("Ticket Not Created", HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<String>("Ticket Created Sussfully", HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<TicketDTO> getTicketById(@PathVariable("id") int id) {
	    System.out.println("findByid");
	    TicketDTO dto = ticketService.getTicketById(id);
	    return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	
	@PostMapping("/update")
	public void updateTicket(@RequestBody Ticket ticket) {
		System.out.println("update");
		ticketService.updateTicket(ticket);
	}
	
	@GetMapping("/all")
	public Iterator<TicketDTO> getAll(){
		return ticketService.allOpenTickets();
	}
	
	
}
