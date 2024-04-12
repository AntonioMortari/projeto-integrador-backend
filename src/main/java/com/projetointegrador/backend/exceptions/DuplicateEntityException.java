package com.projetointegrador.backend.exceptions;

public class DuplicateEntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	public DuplicateEntityException(String message) {
		super(message);
	}
}
