package com.bah.starter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

}
