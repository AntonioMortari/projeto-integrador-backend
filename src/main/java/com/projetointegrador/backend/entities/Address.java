package com.projetointegrador.backend.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "tb_address")
public class Address {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cep;
	private String street;
	private String city;
	private int number;
	private String state;
	private String district;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	public Address() {
	}
	
	
	
	
	public Address(Long id, String cep, String street, String city, int number, String state, String district,
			Client client) {
		super();
		this.id = id;
		this.cep = cep;
		this.street = street;
		this.city = city;
		this.number = number;
		this.state = state;
		this.district = district;
		this.client = client;
	}




	public Address(String cep, String street, String city, int number, String state, String district,
			Client client) {
		this.cep = cep;
		this.street = street;
		this.city = city;
		this.number = number;
		this.state = state;
		this.district = district;
		this.client = client;
	}
	
	

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	

	@JsonIgnore
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(cep, other.cep);
	}
	
	
	
}
