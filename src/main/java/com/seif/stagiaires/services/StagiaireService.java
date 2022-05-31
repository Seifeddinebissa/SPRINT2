package com.seif.stagiaires.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.seif.stagiaires.entities.Stagiaire;
import com.seif.stagiaires.entities.Type;

public interface StagiaireService {

	Stagiaire saveStagiaire(Stagiaire p);
	Stagiaire updateStagiaire(Stagiaire p);
	void deleteStagiaire(Stagiaire p);
	void deleteStagiaireById(Long id);
	Stagiaire getStagiaire(Long id);
	List<Stagiaire> getAllStagiaires();
	Page<Stagiaire> getAllStagiairesParPage(int page, int size);
	Page<Stagiaire> getAllStagiairesByNomParPage(int page, int size, String n);
	Page<Stagiaire> getAllStagiairesByTypeParPage(int page, int size, Long id);
	List<Stagiaire> findByNom(String nom);
	List<Stagiaire> findByNomContains(String nom); 
	List<Stagiaire> findByType (Type type);
	List<Stagiaire> findByTypeIdType(Long id);
	List<Type> getAllTypes();


}
