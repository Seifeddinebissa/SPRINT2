package com.seif.stagiaires.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Type {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idType;
	private String nom;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "type")
	private List<Stagiaire> stagiaires;
	
	public Type() {
		super();
	}


	


	public Type(String nom, String description, List<Stagiaire> stagiaires) {
		super();
		this.nom = nom;
		this.description = description;
		this.stagiaires = stagiaires;
	}





	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}





	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}





	public Long getIdType() {
		return idType;
	}


	public void setIdType(Long idType) {
		this.idType = idType;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}








	
}
