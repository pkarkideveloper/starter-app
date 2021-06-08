package com.bah.starter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9026956142297320971L;

	public ProjectNotFoundException(String message) {
        super(message);
    }
}
