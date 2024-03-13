package com.cibertec.DAWII_EF_LUNA_EVER.service;

import java.util.List;

import com.cibertec.DAWII_EF_LUNA_EVER.model.User;

public interface UserService {
	
	public List<User> list(); 
	public User add(User u);
	public User update(User u);
	public void delete(int id);
	public User getUserByID(int id);
	
}
