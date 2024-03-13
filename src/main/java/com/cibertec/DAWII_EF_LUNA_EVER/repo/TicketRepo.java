package com.cibertec.DAWII_EF_LUNA_EVER.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Ticket;
import com.cibertec.DAWII_EF_LUNA_EVER.model.User;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer>{
	  @Query("SELECT t.user FROM Ticket t WHERE t.category.id = ?1")
	    List<User> findUsersByCategoryId(int categoryId);

}
