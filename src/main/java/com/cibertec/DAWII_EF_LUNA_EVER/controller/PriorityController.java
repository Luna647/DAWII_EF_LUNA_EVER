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

import com.cibertec.DAWII_EF_LUNA_EVER.model.Priority;
import com.cibertec.DAWII_EF_LUNA_EVER.service.PriorityService;

@RestController
@RequestMapping("/url/priority")
@CrossOrigin(origins = "http://localhost:4200")
public class PriorityController {
	
	@Autowired
	PriorityService priorityService;
	
	@GetMapping("/listaPriority")
	@ResponseBody
	public ResponseEntity<List<Priority>> list(){
		
		return new ResponseEntity<>(priorityService.list(), HttpStatus.OK);
	}
	
	@PostMapping("/registraPriority")
	@ResponseBody
	public ResponseEntity<Priority> add(@RequestBody Priority pr) {
		return new ResponseEntity<>(priorityService.add(pr), HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizaPriority")
	@ResponseBody
	public ResponseEntity<Priority> update(@RequestBody Priority pr) {
		return new ResponseEntity<>(priorityService.update(pr), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminaPriority/{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		priorityService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
