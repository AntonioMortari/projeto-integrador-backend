package com.projetointegrador.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.backend.entities.HomeCare;

@Repository
public interface HomeCareRepository extends JpaRepository<HomeCare, Long> {

	
	
}
