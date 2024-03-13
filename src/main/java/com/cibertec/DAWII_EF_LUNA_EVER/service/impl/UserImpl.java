package com.cibertec.DAWII_EF_LUNA_EVER.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.DAWII_EF_LUNA_EVER.model.User;
import com.cibertec.DAWII_EF_LUNA_EVER.repo.UserRepo;
import com.cibertec.DAWII_EF_LUNA_EVER.service.UserService;

@Service
public class UserImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public List<User> list() {
		return userRepo.findAll();
	}

	@Override
	public User add(User u) {
		return userRepo.save(u);
	}

	@Override
	public User update(User u) {
		return userRepo.save(u);
	}

	@Override
	public void delete(int id) {
		userRepo.deleteById(id);
	}

	@Override
	public User getUserByID(int codigo) {
		return userRepo.findById(codigo).orElse(new User());
	}

	
}
