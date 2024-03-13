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

import com.cibertec.DAWII_EF_LUNA_EVER.model.Status;
import com.cibertec.DAWII_EF_LUNA_EVER.service.StatusService;

@RestController
@RequestMapping("/url/status")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {
	
	@Autowired
	StatusService statusService;
	
	@GetMapping("/listaStatus")
	@ResponseBody
	public ResponseEntity<List<Status>> list(){
		
		return new ResponseEntity<>(statusService.list(), HttpStatus.OK);
	}
	
	@PostMapping("/registraStatus")
	@ResponseBody
	public ResponseEntity<Status> add(@RequestBody Status s) {
		return new ResponseEntity<>(statusService.add(s), HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizaStatus")
	@ResponseBody
	public ResponseEntity<Status> update(@RequestBody Status s) {
		return new ResponseEntity<>(statusService.update(s), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminaStatus/{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		statusService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
