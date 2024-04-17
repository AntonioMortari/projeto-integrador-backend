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

import com.projetointegrador.backend.entities.Procedure;
import com.projetointegrador.backend.services.ProcedureService;

@RestController
@RequestMapping(value = "/procedures")
public class ProcedureController {

	@Autowired
	private ProcedureService service;
	
	@GetMapping
	public ResponseEntity<List<Procedure>> index() {
	
		List<Procedure> result = service.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@PostMapping
	public ResponseEntity<Procedure> store(@RequestBody Procedure procedure){
		
		Procedure result = service.create(procedure);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result); 
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> destroy(@PathVariable Long id){
	    service.delete(id);
	    
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> edit(@PathVariable Long id, @RequestBody Procedure obj){
		obj.setId(id);
		service.update(obj);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
		
	
}
