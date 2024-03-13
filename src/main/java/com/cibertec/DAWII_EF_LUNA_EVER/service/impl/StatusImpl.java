package com.cibertec.DAWII_EF_LUNA_EVER.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Status;
import com.cibertec.DAWII_EF_LUNA_EVER.repo.StatusRepo;
import com.cibertec.DAWII_EF_LUNA_EVER.service.StatusService;

@Service
public class StatusImpl implements StatusService{

	@Autowired
	StatusRepo statusRepo;
	
	@Override
	public List<Status> list() {
		return statusRepo.findAll();
	}

	@Override
	public Status add(Status s) {
		return statusRepo.save(s);
	}

	@Override
	public Status update(Status s) {
		return statusRepo.save(s);
	}

	@Override
	public void delete(int id) {
		statusRepo.deleteById(id);
		
	}

}
