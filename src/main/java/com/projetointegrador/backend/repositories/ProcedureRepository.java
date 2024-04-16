package com.projetointegrador.backend.repositories;

import org.springframework.stereotype.Repository;
import com.projetointegrador.backend.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProcedureRepository extends JpaRepository <Procedure, Long> {

	public Procedure findByName(String name);
	
}
