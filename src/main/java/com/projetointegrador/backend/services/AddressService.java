package com.projetointegrador.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetointegrador.backend.entities.Address;
import com.projetointegrador.backend.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	public Address create(Address address) {
		return repository.save(address);
		
	}
	
	public List<Address> findAll(){
		return repository.findAll();
	}
	
	
	
}
