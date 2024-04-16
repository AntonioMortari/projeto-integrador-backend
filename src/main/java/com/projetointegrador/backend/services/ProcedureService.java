package com.projetointegrador.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetointegrador.backend.entities.Procedure;
import com.projetointegrador.backend.exceptions.DuplicateEntityException;
import com.projetointegrador.backend.repositories.ProcedureRepository;

@Service
public class ProcedureService {

	private ProcedureRepository repository;
	
	public List <Procedure> findAll() {
		return repository.findAll();
		
	}
	
	public Procedure create(Procedure procedure) {
		if(repository.findByName(procedure.getName())  != null) {
			throw new DuplicateEntityException("Procedure with name " + procedure.getName() + " exists");
		}
		
		return repository.save(procedure);
		
	}
	
}
