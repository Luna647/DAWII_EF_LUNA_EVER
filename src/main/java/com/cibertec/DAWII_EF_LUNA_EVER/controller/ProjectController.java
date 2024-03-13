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

import com.cibertec.DAWII_EF_LUNA_EVER.model.Project;
import com.cibertec.DAWII_EF_LUNA_EVER.service.ProjectService;

@RestController
@RequestMapping("/url/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/listaProject")
	@ResponseBody
	public ResponseEntity<List<Project>> list(){
		
		return new ResponseEntity<>(projectService.list(), HttpStatus.OK);
	}
	
	@PostMapping("/registraProject")
	@ResponseBody
	public ResponseEntity<Project> add(@RequestBody Project p) {
		return new ResponseEntity<>(projectService.add(p), HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizaProject")
	@ResponseBody
	public ResponseEntity<Project> update(@RequestBody Project p) {
		return new ResponseEntity<>(projectService.update(p), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminaProject/{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		projectService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
