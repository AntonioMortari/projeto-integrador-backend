package com.projetointegrador.backend.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_client")
public class Client {
	
	@Id
	private String cpf;
	private String name;
	private String email;
	private String cep;
	private String contact;
	private String emergency_contact;
	
	@OneToMany(mappedBy = "client")
	private List<Address> addresses;
	
	
	public Client() {
		
	}

	public Client(String cpf, String name, String email, String cep, String contact, String emergency_contact) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.cep = cep;
		this.contact = contact;
		this.emergency_contact = emergency_contact;
	}
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmergency_contact() {
		return emergency_contact;
	}

	public void setEmergency_contact(String emergency_contact) {
		this.emergency_contact = emergency_contact;
	}
	
	
	public List<Address> getAddresses() {
		return addresses;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	
	
}
