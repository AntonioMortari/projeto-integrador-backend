package com.projetointegrador.backend.repositories;

import org.springframework.stereotype.Repository;

import com.projetointegrador.backend.entities.Address;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
