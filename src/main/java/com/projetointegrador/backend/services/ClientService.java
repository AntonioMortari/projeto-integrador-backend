package com.projetointegrador.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetointegrador.backend.entities.Client;
import com.projetointegrador.backend.exceptions.DuplicateEntityException;
import com.projetointegrador.backend.exceptions.NotFoundException;
import com.projetointegrador.backend.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		
		return repository.findAll();
		
	}
	
	public Client create(Client client) {
		
		
		if(repository.findByCpf(client.getCpf()) != null) {
			throw new DuplicateEntityException("Client with cpf " + client.getCpf() + " exists");
		}
		
		if(repository.findByEmail(client.getEmail()) != null) {
			throw new DuplicateEntityException("Client with email " + client.getEmail() + " exists");
		}
		
		return repository.save(client);
		
	}
	
	public void delete(String cpf) {
		
		Client findClient = repository.findByCpf(cpf);
		
		if(findClient == null) {
			throw new NotFoundException("Client not found");
		}
		
		repository.deleteById(cpf);
		
	}
	
	public void update(Client obj) {
		Client findClient = repository.findByCpf(obj.getCpf());
		
		if(findClient == null) {
			throw new NotFoundException("Client not found");
		}
		
		updateData(obj, findClient);
		
		repository.save(findClient);
	}
	
	private void updateData(Client obj, Client findClient) {
		findClient.setName(obj.getName());
		findClient.setEmail(obj.getEmail());
		findClient.setContact(obj.getContact());
		findClient.setEmergency_contact(obj.getEmergency_contact());
	}
	

}
