package com.cibertec.DAWII_EF_LUNA_EVER.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Ticket;
import com.cibertec.DAWII_EF_LUNA_EVER.model.User;
import com.cibertec.DAWII_EF_LUNA_EVER.repo.TicketRepo;
import com.cibertec.DAWII_EF_LUNA_EVER.service.TicketService;

@Service
public class TicketImpl implements TicketService{

	@Autowired
	TicketRepo ticketRepo;
	
	@Override
	public List<Ticket> list() {
		return ticketRepo.findAll();
	}

	@Override
	public Ticket add(Ticket t) {
		return ticketRepo.save(t);
	}

	@Override
	public Ticket update(Ticket t) {
		return ticketRepo.save(t);
	}

	@Override
	public void delete(int id) {
		ticketRepo.deleteById(id);
		
	}

	@Override
	public List<User> findUsersByCategoryId(int categoryId) {
		return ticketRepo.findUsersByCategoryId(categoryId);
	}

}
