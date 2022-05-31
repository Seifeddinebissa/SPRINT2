package com.seif.stagiaires.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.seif.stagiaires.entities.Stagiaire;
import com.seif.stagiaires.entities.Type;
import com.seif.stagiaires.repositorys.StagiaireRepository;
import com.seif.stagiaires.repositorys.TypeRepository;

@Service
public class StagiaireServiceImpl implements StagiaireService {

	@Autowired
	StagiaireRepository stagiaireRepository; 
	
	@Autowired
	TypeRepository typeRepository;
	
	@Override
	public Stagiaire saveStagiaire(Stagiaire s) {
		
		return stagiaireRepository.save(s);
	}

	@Override
	public Stagiaire updateStagiaire(Stagiaire s) {
		return stagiaireRepository.save(s);
	}

	@Override
	public void deleteStagiaire(Stagiaire s) {
		stagiaireRepository.delete(s);
	}

	@Override
	public void deleteStagiaireById(Long id) {
		stagiaireRepository.deleteById(id);
	}

	@Override
	public Stagiaire getStagiaire(Long id) {
		return stagiaireRepository.findById(id).get();
	}

	@Override
	public List<Stagiaire> getAllStagiaires() {
		return stagiaireRepository.findAll();
	}
	
	@Override
	public Page<Stagiaire> getAllStagiairesParPage(int page, int size) {
		return stagiaireRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public Page<Stagiaire> getAllStagiairesByNomParPage(int page, int size, String n) {
		List<Stagiaire> list = stagiaireRepository.findByNomContains(n);
		Page<Stagiaire> p = new PageImpl<Stagiaire>(list, PageRequest.of(page, size), list.size());
		return p;
		/*return stagiaireRepository.findAll(PageRequest.of(page, size));*/
	}
	
	@Override
	public List<Stagiaire> findByNom(String nom) {
		return stagiaireRepository.findByNom(nom);
	}

	@Override
	public List<Stagiaire> findByNomContains(String nom) {
		return stagiaireRepository.findByNomContains(nom);
	}

	@Override
	public List<Stagiaire> findByType(Type type) {
		return stagiaireRepository.findByType(type);
	}

	@Override
	public List<Stagiaire> findByTypeIdType(Long id) {
		return stagiaireRepository.findByTypeIdType(id);
	}

	@Override
	public List<Type> getAllTypes() {
		return typeRepository.findAll();
	}

	@Override
	public Page<Stagiaire> getAllStagiairesByTypeParPage(int page, int size, Long id) {
		List<Stagiaire> list = stagiaireRepository.findByTypeIdType(id);
		Page<Stagiaire> p = new PageImpl<Stagiaire>(list, PageRequest.of(page, size), list.size());
		return p;
	}




}
