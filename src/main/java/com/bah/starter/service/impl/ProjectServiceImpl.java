package com.bah.starter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.starter.domain.ProjectData;
import com.bah.starter.exceptions.ProjectIdException;
import com.bah.starter.exceptions.ProjectNotFoundException;
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
public ProjectData findByProjectIdentifier(String projectId) {
	ProjectData pdata =projrepo.findByProjectIdentifier(projectId.toUpperCase());
	if(pdata ==null) {
		throw new ProjectIdException(" Project does not existsprojectId");
	}
	return pdata;
	
}
public Iterable<ProjectData> findAllProjects(){
	return projrepo.findAll();
}
//List implementation
public List<ProjectData> findAllprojectData(){
	return (List<ProjectData>) projrepo.findAll();
	
}
public String deleteProjectByIdentifier(String projectId){
    ProjectData project = projrepo.findByProjectIdentifier(projectId.toUpperCase());

    if(project == null){
        throw new ProjectNotFoundException("Cannot delete project: "+projectId+" as it doesn't exist");
    }

    projrepo.delete(project);
    return "project deleted";

}

}
