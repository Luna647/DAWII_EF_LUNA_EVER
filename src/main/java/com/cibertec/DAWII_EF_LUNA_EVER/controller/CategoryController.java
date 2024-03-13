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

import com.cibertec.DAWII_EF_LUNA_EVER.model.Category;
import com.cibertec.DAWII_EF_LUNA_EVER.service.CategoryService;

@RestController
@RequestMapping("/url/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/listaCategory")
	@ResponseBody
	public ResponseEntity<List<Category>> list(){
		
		return new ResponseEntity<>(categoryService.list(), HttpStatus.OK);
	}
	
	@PostMapping("/registraCategory")
	@ResponseBody
	public ResponseEntity<Category> add(@RequestBody Category c) {
		return new ResponseEntity<>(categoryService.add(c), HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizaCategory")
	@ResponseBody
	public ResponseEntity<Category> update(@RequestBody Category c) {
		return new ResponseEntity<>(categoryService.update(c), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminaCategory/{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		categoryService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
