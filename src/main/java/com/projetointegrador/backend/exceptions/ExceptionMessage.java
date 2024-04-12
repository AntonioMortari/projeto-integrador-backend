package com.projetointegrador.backend.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionMessage {

	private HttpStatus statusCode;
	private String message;
	private String timestamp;
	private String path;
	
	public ExceptionMessage(HttpStatus statusCode, String message, String timestamp, String path) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timestamp = timestamp;
		this.path = path;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
