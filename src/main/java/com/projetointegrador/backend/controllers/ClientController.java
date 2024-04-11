package com.projetointegrador.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegrador.backend.entities.Client;
import com.projetointegrador.backend.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> index(){
		
		List<Client> result = service.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
}
