package com.seif.stagiaires.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Stagiaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStagiaire;

	@NotNull
	@Size(min = 4, max = 30)
	private String nom;

	@NotNull
	@Size(min = 8, max = 8)
	private String cin;
	private String societe;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent
	private Date dateDeb;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent
	private Date dateFin;
	
	@ManyToOne
	private Type type;

	public Stagiaire() {
		super();
	}

	

	public Stagiaire(String nom, String cin, String societe, Date dateDeb, Date dateFin, Type type) {
		super();
		this.nom = nom;
		this.cin = cin;
		this.societe = societe;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.type = type;
	}



	public Long getIdStagiaire() {
		return idStagiaire;
	}

	public void setIdStagiaire(Long idStagiaire) {
		this.idStagiaire = idStagiaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Stagiaire [idStagiaire=" + idStagiaire + ", nom=" + nom + ", cin=" + cin + ", societe=" + societe
				+ ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + ", type=" + type + "]";
	}




	

}
