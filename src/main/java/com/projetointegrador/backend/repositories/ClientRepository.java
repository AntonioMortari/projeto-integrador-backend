package com.projetointegrador.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.backend.entities.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
	
	public Client findByCpf(String cpf);
	
	public Client findByEmail(String email);
	
}
