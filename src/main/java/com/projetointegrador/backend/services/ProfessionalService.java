package com.projetointegrador.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetointegrador.backend.entities.Professional;
import com.projetointegrador.backend.exceptions.DuplicateEntityException;
import com.projetointegrador.backend.exceptions.NotFoundException;
import com.projetointegrador.backend.repositories.ProfessionalRepository;

@Service
public class ProfessionalService {

	@Autowired
	private ProfessionalRepository repository;
	
	public List<Professional> findAll(){
		return repository.findAll();
	}
	
	public Professional create(Professional professional) {
		
		Professional findProfessional = repository.findByLogin(professional.getLogin());
		
		if(findProfessional != null) {
			throw new DuplicateEntityException("Professional with login" + professional.getLogin() + " exists");
		}
		
		return repository.save(professional);
		
	}
	
	public void delete(Long id) {
		repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Professional not found"));
		
		repository.deleteById(id);
	}
	
	public void update(Professional obj) {
		Professional findProfessional = repository.findById(obj.getId())
			.orElseThrow(() -> new NotFoundException("Professional not found"));
		
		updateData(obj, findProfessional);
		
		repository.save(findProfessional);
	}
	
	private void updateData(Professional obj, Professional findProfessional) {
		findProfessional.setLogin(obj.getLogin());
		findProfessional.setName(obj.getName());
		findProfessional.setEmail(obj.getEmail());
		findProfessional.setPassword(obj.getPassword());
	}
	
}
