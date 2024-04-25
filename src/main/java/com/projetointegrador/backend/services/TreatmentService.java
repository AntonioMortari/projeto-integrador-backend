package com.projetointegrador.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetointegrador.backend.entities.Treatment;
import com.projetointegrador.backend.exceptions.NotFoundException;
import com.projetointegrador.backend.repositories.TreatmentRepository;

@Service
public class TreatmentService {

	@Autowired
	private TreatmentRepository repository;
	
	public List<Treatment> findAll(){
		return repository.findAll();
	}
	
	public Treatment findOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Treatment not found"));
	}
	
}
