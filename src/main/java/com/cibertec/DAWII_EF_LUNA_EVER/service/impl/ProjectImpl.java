package com.cibertec.DAWII_EF_LUNA_EVER.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Project;
import com.cibertec.DAWII_EF_LUNA_EVER.repo.ProjectRepo;
import com.cibertec.DAWII_EF_LUNA_EVER.service.ProjectService;

@Service
public class ProjectImpl implements ProjectService{

	@Autowired
	ProjectRepo projectRepo;
	
	@Override
	public List<Project> list() {
		return projectRepo.findAll();
	}

	@Override
	public Project add(Project p) {
		return projectRepo.save(p);
	}

	@Override
	public Project update(Project p) {
		return projectRepo.save(p);
	}

	@Override
	public void delete(int id) {
		projectRepo.deleteById(id);
	}

}
