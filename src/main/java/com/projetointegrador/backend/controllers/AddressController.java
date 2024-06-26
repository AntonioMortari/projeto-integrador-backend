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

import com.projetointegrador.backend.entities.Address;
import com.projetointegrador.backend.services.AddressService;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {

	@Autowired
	private AddressService service;
	
	@PostMapping
	public ResponseEntity<Address> store(@RequestBody Address address){
		
		Address result = service.create(address);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Address>> index(){
		
		List<Address> result = service.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> edit(@PathVariable Long id, @RequestBody Address address) {
		
		service.update(id, address);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> destroy(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
