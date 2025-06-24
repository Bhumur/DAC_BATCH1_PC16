package com.bhumur.Ticket.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bhumur.Ticket.entity.Ticket;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Integer> {

	public Optional<Ticket> findByPhonenumber(String phonenumber);
	
	@Query(value="SELECT t FROM Ticket t WHERE t.status = 'OPEN'")
	public List<Ticket> findAllByStatus();
}
