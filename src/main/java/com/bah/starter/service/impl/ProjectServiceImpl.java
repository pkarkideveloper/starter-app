package com.bah.starter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.starter.domain.ProjectData;
import com.bah.starter.repository.ProjectRepository;
import com.bah.starter.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired 
	private ProjectRepository projrepo;
	public ProjectData saveorUpdateProjectData (ProjectData projdata){
		return projrepo.save(projdata);
	}

	

}
