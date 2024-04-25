package com.projetointegrador.backend.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_homecare")
public class HomeCare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date startAt;
	private Date finishAt;
	private String indications;
	
	@OneToMany(mappedBy = "homecare")
	private List<Treatment> treatments = new ArrayList<Treatment>();
	
	public HomeCare() {
		super();
	}
	public HomeCare(Long id, Date startAt, Date finishAt, String indications) {
		super();
		this.id = id;
		this.startAt = startAt;
		this.finishAt = finishAt;
		this.indications = indications;
	}
	
	public HomeCare(Date startAt, Date finishAt, String indications) {
		this.startAt = startAt;
		this.finishAt = finishAt;
		this.indications = indications;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartAt() {
		return startAt;
	}
	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}
	public Date getFinishAt() {
		return finishAt;
	}
	public void setFinishAt(Date finishAt) {
		this.finishAt = finishAt;
	}
	public String getIndications() {
		return indications;
	}
	public void setIndications(String indications) {
		this.indications = indications;
	}
	
	@JsonIgnore
	public List<Treatment> getTreatments() {
		return treatments;
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
		HomeCare other = (HomeCare) obj;
		return Objects.equals(id, other.id);
	}

}
