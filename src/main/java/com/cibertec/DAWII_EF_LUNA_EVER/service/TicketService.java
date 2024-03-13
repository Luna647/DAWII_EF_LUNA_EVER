package com.cibertec.DAWII_EF_LUNA_EVER.service;

import java.util.List;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Ticket;
import com.cibertec.DAWII_EF_LUNA_EVER.model.User;

public interface TicketService {
	
	public List<Ticket> list(); 
	public Ticket add(Ticket t);
	public Ticket update(Ticket t);
	public void delete(int id);

	List<User> findUsersByCategoryId(int categoryId);
}
