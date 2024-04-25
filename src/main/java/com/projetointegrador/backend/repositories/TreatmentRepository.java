package com.projetointegrador.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.backend.entities.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long>{
}
