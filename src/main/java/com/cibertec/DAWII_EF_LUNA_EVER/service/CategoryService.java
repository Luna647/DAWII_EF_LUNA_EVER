package com.cibertec.DAWII_EF_LUNA_EVER.service;

import java.util.List;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Category;

public interface CategoryService {
	
	public List<Category> list(); 
	public Category add(Category c);
	public Category update(Category c);
	public void delete(int id);


}
