package com.seif.stagiaires.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.seif.stagiaires.entities.Stagiaire;
import com.seif.stagiaires.entities.Type;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Long>{

	List<Stagiaire> findByNom(String nom);
	List<Stagiaire> findByNomContains(String nom); 
	
	@Query("select s from Stagiaire s where s.type = ?1")
	List<Stagiaire> findByType (Type type);
	
	List<Stagiaire> findByTypeIdType(Long id);

}
