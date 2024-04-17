package com.projetointegrador.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetointegrador.backend.entities.Procedure;
import com.projetointegrador.backend.exceptions.DuplicateEntityException;
import com.projetointegrador.backend.exceptions.NotFoundException;
import com.projetointegrador.backend.repositories.ProcedureRepository;

@Service
public class ProcedureService {

	@Autowired
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
	
	public void delete(Long id) {
		
		repository.findById(id)
			    .orElseThrow(() -> new NotFoundException("Procedure not found"));
		
		repository.deleteById(id);
	
	}
	
	public void update(Procedure obj) {
		Procedure findProcedure = repository.findById(obj.getId())
				.orElseThrow(() -> new NotFoundException("Procedure not found"));
		
		
		updateData(obj, findProcedure);
		repository.save(findProcedure);
		
	}
	
	private void updateData(Procedure obj, Procedure findProcedure) {
		findProcedure.setName(obj.getName());
		findProcedure.setDescription(obj.getDescription());
		findProcedure.setPrice(obj.getPrice());
		findProcedure.setDuration(obj.getDuration());
	}
	
}
