package com.bah.starter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.starter.domain.ProjectData;
import com.bah.starter.exceptions.ProjectIdException;
import com.bah.starter.repository.ProjectRepository;
import com.bah.starter.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
    private ProjectRepository projrepo;

    public ProjectData saveorUpdateProjectData(ProjectData project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projrepo.save(project);
        }
        catch(Exception e) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
        }
    }

	

}
