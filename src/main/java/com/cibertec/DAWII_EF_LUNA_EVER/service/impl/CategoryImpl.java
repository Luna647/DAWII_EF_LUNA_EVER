package com.cibertec.DAWII_EF_LUNA_EVER.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Category;
import com.cibertec.DAWII_EF_LUNA_EVER.repo.CategoryRepo;
import com.cibertec.DAWII_EF_LUNA_EVER.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService{
	
	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public List<Category> list() {
		return categoryRepo.findAll();
	}

	@Override
	public Category add(Category c) {
		return categoryRepo.save(c);
	}

	@Override
	public Category update(Category c) {
		return categoryRepo.save(c);
	}

	@Override
	public void delete(int id) {
		categoryRepo.deleteById(id);
		
	}

}
