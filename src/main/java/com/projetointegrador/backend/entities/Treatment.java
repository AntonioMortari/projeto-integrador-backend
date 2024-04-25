package com.projetointegrador.backend.entities;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetointegrador.backend.enums.PaymentMethods;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "/tb_treatment")
public class Treatment {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "professional_id")
	private Professional professional;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "procedure_id")
	private Procedure procedure;
	
	
	private PaymentMethods payment;
	
	private String observation;
	
	@ManyToOne
	@JoinColumn(name = "homecare_id")
	private HomeCare homecare;

	public Treatment() {
		super();
	}

	public Treatment(Long id, Client client, Professional professional, Date date, Procedure procedure, PaymentMethods payment,
			String observation, HomeCare homecare) {
		super();
		this.id = id;
		this.client = client;
		this.professional = professional;
		this.date = date;
		this.procedure = procedure;
		this.payment = payment;
		this.observation = observation;
		this.homecare = homecare;
	}
	

	public Treatment(Client client, Professional professional, Date date, Procedure procedure, PaymentMethods payment,
			String observation, HomeCare homecare) {
		super();
		this.client = client;
		this.professional = professional;
		this.date = date;
		this.procedure = procedure;
		this.payment = payment;
		this.observation = observation;
		this.homecare = homecare;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public PaymentMethods getPayment() {
		return payment;
	}

	public void setPayment(PaymentMethods payment) {
		this.payment = payment;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	
	public HomeCare getHomecare() {
		return homecare;
	}

	public void setHomecare(HomeCare homecare) {
		this.homecare = homecare;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treatment other = (Treatment) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
