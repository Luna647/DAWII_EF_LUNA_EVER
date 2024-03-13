package com.cibertec.DAWII_EF_LUNA_EVER.service;

import java.util.List;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Status;

public interface StatusService {

	public List<Status> list(); 
	public Status add(Status s);
	public Status update(Status s);
	public void delete(int id);
}
