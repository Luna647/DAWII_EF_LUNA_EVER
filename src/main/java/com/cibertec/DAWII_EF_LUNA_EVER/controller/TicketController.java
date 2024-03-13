package com.cibertec.DAWII_EF_LUNA_EVER.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Ticket;
import com.cibertec.DAWII_EF_LUNA_EVER.model.User;
import com.cibertec.DAWII_EF_LUNA_EVER.service.TicketService;

@RestController
@RequestMapping("/url/")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@GetMapping("/listaTicket")
	@ResponseBody
	public ResponseEntity<List<Ticket>> list(){
		
		return new ResponseEntity<>(ticketService.list(), HttpStatus.OK);
	}
	
	@PostMapping("/registraTicket")
	@ResponseBody
	public ResponseEntity<Ticket> add(@RequestBody Ticket t) {
		return new ResponseEntity<>(ticketService.add(t), HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizaTicket")
	@ResponseBody
	public ResponseEntity<Ticket> update(@RequestBody Ticket t) {
		return new ResponseEntity<>(ticketService.update(t), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminaTicket/{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		ticketService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/usersByCategory/{categoryId}")
    public ResponseEntity<List<User>> getUsersByCategoryId(@PathVariable int categoryId) {
        List<User> usersByCategory = ticketService.findUsersByCategoryId(categoryId);
        return ResponseEntity.ok(usersByCategory);
    }

}

