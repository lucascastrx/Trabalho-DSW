package com.dsw.TrabalhoDSW.exceptions.resourceException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.boot.model.relational.Database;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dsw.TrabalhoDSW.exceptions.serviceException.DatabaseException;
import com.dsw.TrabalhoDSW.exceptions.serviceException.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void resourceNotFound(ResourceNotFoundException e, HttpServletRequest req) {
		
	}
	
	@ExceptionHandler(DatabaseException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void resourceNotFound(DatabaseException e, HttpServletRequest req) {
		
	}
	
	
}
