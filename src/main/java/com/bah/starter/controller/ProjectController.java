package com.bah.starter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.starter.domain.ProjectData;
import com.bah.starter.service.ErrorValidationService;
import com.bah.starter.service.impl.ProjectServiceImpl;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectServiceImpl projservimpl;
	@Autowired
	ErrorValidationService evs;

	// Validation and Binding Result for error handling
	@PostMapping("/create")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody ProjectData pdata, BindingResult result) {

		ResponseEntity<?> errorMap = evs.ErrorValidationService(result);
		if (errorMap != null)
			return errorMap;

		/*
		 * public ResponseEntity<?> createNewProject(@Valid @RequestBody ProjectData
		 * pdata, BindingResult result) {
		 * 
		 * if (result.hasErrors()) { return new
		 * ResponseEntity<String>("Invalid object",HttpStatus.BAD_REQUEST); }
		 */
		projservimpl.saveorUpdateProjectData(pdata);
		return new ResponseEntity<ProjectData>(pdata, HttpStatus.CREATED);

	}

	@GetMapping("/get/{projectId}")
	public ResponseEntity<?> findProjectById(@PathVariable String projectId) {
		ProjectData pdata = projservimpl.findByProjectIdentifier(projectId);
		return new ResponseEntity<ProjectData>(pdata, HttpStatus.OK);////

	}
    //list implementation of below method
	@GetMapping("/get/getAllList")
	public List <ProjectData> getAllProjectDataList() {
		return (List<ProjectData>) projservimpl.findAllprojectData();
	}
	
	@GetMapping("/get/getAll")
	public Iterable <ProjectData> getAllProjectData() {
		return  projservimpl.findAllprojectData();
	}
	
	@DeleteMapping ("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId){
		projservimpl.deleteProjectByIdentifier(projectId);

        return new ResponseEntity<String>("Project "+projectId+" deleted successfully", HttpStatus.OK);
    }
}
