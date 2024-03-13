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

import com.cibertec.DAWII_EF_LUNA_EVER.model.Kind;
import com.cibertec.DAWII_EF_LUNA_EVER.service.KindService;

@RestController
@RequestMapping("/url/kind")
@CrossOrigin(origins = "http://localhost:4200")
public class KindController {
	
	@Autowired
	KindService kindService;
	
	@GetMapping("/listaKind")
	@ResponseBody
	public ResponseEntity<List<Kind>> list(){
		
		return new ResponseEntity<>(kindService.list(), HttpStatus.OK);
	}
	
	@PostMapping("/registraKind")
	@ResponseBody
	public ResponseEntity<Kind> add(@RequestBody Kind k) {
		return new ResponseEntity<>(kindService.add(k), HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizaKind")
	@ResponseBody
	public ResponseEntity<Kind> update(@RequestBody Kind k) {
		return new ResponseEntity<>(kindService.update(k), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminaKind/{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		kindService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
