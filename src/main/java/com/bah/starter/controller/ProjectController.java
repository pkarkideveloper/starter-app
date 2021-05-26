package com.bah.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.starter.domain.ProjectData;
import com.bah.starter.service.impl.ProjectServiceImpl;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectServiceImpl projservimpl;
	
	@PostMapping("/create")
	public ResponseEntity<ProjectData> createNewProject(@RequestBody ProjectData pdata){
		projservimpl.saveorUpdateProjectData(pdata);
		return new ResponseEntity<ProjectData>(pdata, HttpStatus.CREATED);
		
	}
	

}
