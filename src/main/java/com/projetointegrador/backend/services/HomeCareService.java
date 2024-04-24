package com.projetointegrador.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetointegrador.backend.entities.HomeCare;
import com.projetointegrador.backend.exceptions.DuplicateEntityException;
import com.projetointegrador.backend.exceptions.NotFoundException;
import com.projetointegrador.backend.repositories.HomeCareRepository;

@Service
public class HomeCareService {
	
	@Autowired
	private HomeCareRepository repository;
	
	public List<HomeCare> findAll(){
		
		return repository.findAll();
	}
	
	public HomeCare findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("HomeCare not found"));
		
	}
	
	public HomeCare create(HomeCare homeCare) {
		if(repository.findById(homeCare.getId()) != null) {
			throw new DuplicateEntityException("HomeCare with id" + homeCare.getId() + "exist") ;
		}
		
		return repository.save(homeCare);
	}
	
	
	public void delete(Long id) {
		repository.findById(id).orElseThrow(() -> new NotFoundException("HomeCare not found"));
		
		repository.deleteById(id);
	}
	
	public void update(HomeCare obj) {
		HomeCare findHomeCare = repository.findById(obj.getId()).orElseThrow(() -> new NotFoundException("HomeCare not found"));
		
		System.out.println("Passou!!!");
		
		updateData(obj, findHomeCare);
		
		repository.save(findHomeCare);
		
	}
	
	private void updateData(HomeCare obj, HomeCare findHomeCare) {
		findHomeCare.setStartAt(obj.getStartAt());
		findHomeCare.setFinishAt(obj.getFinishAt());
		findHomeCare.setIndications(obj.getIndications());
	}
	
	
	
}
