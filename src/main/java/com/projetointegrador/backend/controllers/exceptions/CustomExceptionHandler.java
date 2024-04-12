package com.projetointegrador.backend.controllers.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projetointegrador.backend.exceptions.DuplicateEntityException;
import com.projetointegrador.backend.exceptions.ExceptionMessage;
import com.projetointegrador.backend.exceptions.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(DuplicateEntityException.class)
	public ResponseEntity<ExceptionMessage> duplicateEntityException(DuplicateEntityException e, HttpServletRequest request){
		ExceptionMessage message = new ExceptionMessage(HttpStatus.BAD_REQUEST, e.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionMessage> notFoundException(NotFoundException e, HttpServletRequest request){
		ExceptionMessage message = new ExceptionMessage(HttpStatus.NOT_FOUND, e.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}
	
	
	
	
}
