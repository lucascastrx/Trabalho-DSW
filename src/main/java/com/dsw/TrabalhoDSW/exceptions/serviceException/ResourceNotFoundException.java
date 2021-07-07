package com.dsw.TrabalhoDSW.exceptions.serviceException;
/**
 * @author Lucas Teixeira
 * @author Eduardo Buzzi
 */
public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(Object id) {
		super("Resource not found");
	}

}
