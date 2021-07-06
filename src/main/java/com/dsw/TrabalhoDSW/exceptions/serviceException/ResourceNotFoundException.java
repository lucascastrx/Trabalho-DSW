package com.dsw.TrabalhoDSW.exceptions.serviceException;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(Object id) {
		super("Resource not found");
	}

}
