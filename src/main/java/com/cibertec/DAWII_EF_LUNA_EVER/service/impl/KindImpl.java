package com.cibertec.DAWII_EF_LUNA_EVER.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Kind;
import com.cibertec.DAWII_EF_LUNA_EVER.repo.KindRepo;
import com.cibertec.DAWII_EF_LUNA_EVER.service.KindService;

@Service
public class KindImpl implements KindService{
	
	@Autowired
	KindRepo kindRepo;

	@Override
	public List<Kind> list() {
		return kindRepo.findAll();
	}

	@Override
	public Kind add(Kind k) {
		return kindRepo.save(k);
	}

	@Override
	public Kind update(Kind k) {
		return kindRepo.save(k);
	}

	@Override
	public void delete(int id) {
		kindRepo.deleteById(id);
		
	}

}
