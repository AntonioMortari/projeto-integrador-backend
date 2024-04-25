package com.projetointegrador.backend.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetointegrador.backend.entities.Address;
import com.projetointegrador.backend.entities.Client;
import com.projetointegrador.backend.entities.HomeCare;
import com.projetointegrador.backend.entities.Procedure;
import com.projetointegrador.backend.entities.Professional;
import com.projetointegrador.backend.entities.Treatment;
import com.projetointegrador.backend.enums.PaymentMethods;
import com.projetointegrador.backend.repositories.AddressRepository;
import com.projetointegrador.backend.repositories.ClientRepository;
import com.projetointegrador.backend.repositories.HomeCareRepository;
import com.projetointegrador.backend.repositories.ProcedureRepository;
import com.projetointegrador.backend.repositories.ProfessionalRepository;
import com.projetointegrador.backend.repositories.TreatmentRepository;

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
	
	@Autowired
	private HomeCareRepository homeCareRepository;
	
	@Autowired
	private TreatmentRepository treatmentRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Client c1 = new Client("54600000000", "antonio", "antonio@test.com", "19999999999", "19999999999");
		Address a1 = new Address("13091530", "Rua da Kathyn", "Campinas", 123, "São Paulo", "Vida Nova", c1 );
		Procedure p1 = new Procedure("Procedimento 1", "Primeiro procedimento", 55, 2);
		Professional pr1 = new Professional("Profissional1", "admin", "123admin", "profissional@test.com");
		
		String finishAtString = "28/04/2024";
		
		Date parsedDate;
		try {
			parsedDate = sdf.parse(finishAtString);
		} catch (Exception e) {
			throw new Exception();
		}
		
		HomeCare h1 = new HomeCare(new Date(), parsedDate, "Indicações");
		
		Treatment t1 = new Treatment(c1, pr1, new Date(), p1, PaymentMethods.CARTAO_DEBITO, "Observação", h1);
		
		
		clientRepository.save(c1);
		addressRepository.save(a1);
		procedureRepository.save(p1);
		professionalRepository.save(pr1);
		homeCareRepository.save(h1);
		treatmentRepository.save(t1);
		
	}

}
