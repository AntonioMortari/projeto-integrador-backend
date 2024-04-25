package com.projetointegrador.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{cpf}")
	public ResponseEntity<Client> show(@PathVariable String cpf){
		
		Client result = service.findOne(cpf);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@PostMapping
	public ResponseEntity<Client> store(@RequestBody Client client){
		
		Client result = service.create(client);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
		
	}
	
	@DeleteMapping(value = "/{cpf}")
	public ResponseEntity<Void> destroy(@PathVariable String cpf){
		service.delete(cpf);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping(value = "/{cpf}")
	public ResponseEntity<Void> edit(@PathVariable String cpf, @RequestBody Client obj){
		obj.setCpf(cpf);
		service.update(obj);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
