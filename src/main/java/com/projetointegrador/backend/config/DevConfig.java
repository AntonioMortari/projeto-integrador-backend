package com.projetointegrador.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetointegrador.backend.entities.Client;
import com.projetointegrador.backend.repositories.ClientRepository;

@Configuration
@Profile("development")
public class DevConfig implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Client c1 = new Client("54600000000", "antonio", "antonio@test.com", "13000000", "19999999999", "19999999999");
		
		clientRepository.save(c1);
		
	}

		
	
}
