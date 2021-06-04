package com.bah.starter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6583648886700933507L;

	public ProjectIdException(String message) {
		super(message);
	}
}
