package com.cibertec.DAWII_EF_LUNA_EVER.service;

import java.util.List;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Priority;

public interface PriorityService {

	public List<Priority> list(); 
	public Priority add(Priority pr);
	public Priority update(Priority pr);
	public void delete(int id);
}
