package com.projetointegrador.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetointegrador.backend.entities.Address;
import com.projetointegrador.backend.exceptions.NotFoundException;
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
	
	public void update(Long id, Address address) {
		Address findAddress = repository.findById(id)
			    .orElseThrow(() -> new NotFoundException("Address not found"));
		
		updateData(address, findAddress);
		
		repository.save(findAddress);
		
	}
	
	public void delete(Long id) {
		Address findAddress = repository.findById(id)
			    .orElseThrow(() -> new NotFoundException("Address not found"));
		
		repository.deleteById(id);
	}
	
	private void updateData(Address address, Address findAddress) {
		findAddress.setCep(address.getCep());
		findAddress.setCity(address.getCity());
		findAddress.setClient(address.getClient());
	    findAddress.setDistrict(address.getDistrict());
	    findAddress.setNumber(address.getNumber());
	    findAddress.setState(address.getState());
	    findAddress.setStreet(address.getStreet());
	}
	
}
