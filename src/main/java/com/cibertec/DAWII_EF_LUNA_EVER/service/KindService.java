package com.cibertec.DAWII_EF_LUNA_EVER.service;

import java.util.List;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Kind;

public interface KindService {
	
	public List<Kind> list(); 
	public Kind add(Kind k);
	public Kind update(Kind k);
	public void delete(int id);

}
