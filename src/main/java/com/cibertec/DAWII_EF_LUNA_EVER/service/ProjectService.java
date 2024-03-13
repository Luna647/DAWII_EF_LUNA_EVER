package com.cibertec.DAWII_EF_LUNA_EVER.service;

import java.util.List;

import com.cibertec.DAWII_EF_LUNA_EVER.model.Project;

public interface ProjectService {

	public List<Project> list(); 
	public Project add(Project p);
	public Project update(Project p);
	public void delete(int id);
}
