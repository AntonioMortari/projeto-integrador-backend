package com.projetointegrador.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.backend.entities.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
	
	public Professional findByLogin(String login);
	
}
