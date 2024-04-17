package com.projetointegrador.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetointegrador.backend.entities.Address;
import com.projetointegrador.backend.entities.Client;
import com.projetointegrador.backend.entities.Procedure;
import com.projetointegrador.backend.entities.Professional;
import com.projetointegrador.backend.repositories.AddressRepository;
import com.projetointegrador.backend.repositories.ClientRepository;
import com.projetointegrador.backend.repositories.ProcedureRepository;
import com.projetointegrador.backend.repositories.ProfessionalRepository;

@Configuration
@Profile("development")
public class DevConfig implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ProcedureRepository procedureRepository;
	
	@Autowired
	private ProfessionalRepository professionalRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Client c1 = new Client("54600000000", "antonio", "antonio@test.com", "13000000", "19999999999", "19999999999");
		Address a1 = new Address("13091530", "Rua da Kathyn", "Campinas", 123, "São Paulo", "Vida Nova", c1 );
		Procedure p1 = new Procedure("Procedimento 1", "Primeiro procedimento", 55, 2);
		Professional pr1 = new Professional("Profissional1", "admin", "123admin", "profissional@test.com");
		
		
		clientRepository.save(c1);
		addressRepository.save(a1);
		procedureRepository.save(p1);
		professionalRepository.save(pr1);
		
	}

}
