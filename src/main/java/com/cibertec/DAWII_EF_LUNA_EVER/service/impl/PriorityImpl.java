package com.cibertec.DAWII_EF_LUNA_EVER.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Priority;
import com.cibertec.DAWII_EF_LUNA_EVER.repo.PriorityRepo;
import com.cibertec.DAWII_EF_LUNA_EVER.service.PriorityService;

@Service
public class PriorityImpl implements PriorityService{

	@Autowired
	PriorityRepo priorityRepo;
	
	@Override
	public List<Priority> list() {
		return priorityRepo.findAll();
	}

	@Override
	public Priority add(Priority pr) {
		return priorityRepo.save(pr);
	}

	@Override
	public Priority update(Priority pr) {
		return priorityRepo.save(pr);
	}

	@Override
	public void delete(int id) {
		priorityRepo.deleteById(id);
		
	}

}
