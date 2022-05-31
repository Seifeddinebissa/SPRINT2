package com.seif.stagiaires;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.seif.stagiaires.entities.Stagiaire;
import com.seif.stagiaires.entities.Type;
import com.seif.stagiaires.repositorys.StagiaireRepository;
import com.seif.stagiaires.services.StagiaireService;

@SpringBootTest
class StagiairesApplicationTests {

	@Autowired
	StagiaireRepository stagiaireRepository;
	@Autowired
	StagiaireService stagiareService;
	
	@Test
	void contextLoads() {
	}
	
	/*@Test
	public void testCreateStagiare() {
		Stagiaire st = new Stagiaire("seif eddine","14418805","designet",new Date(),new Date());
		stagiaireRepository.save(st);
	}*/
	
	@Test
	public void findStagiaire() {
		Stagiaire st = stagiaireRepository.findById(1L).get();
		System.out.println(st);
	}
	
	@Test
	public void updateStagiaire() {
		Stagiaire st = stagiaireRepository.findById(1L).get();
		st.setSociete("intelect");
		stagiaireRepository.save(st);
	}

	@Test
	public void findStagiaireByNom() {
		List<Stagiaire> st = stagiaireRepository.findByNomContains("seif");
		for(Stagiaire s:st) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testfindByCategorie() {
		Type t = new Type();
		t.setIdType(2L);
		List<Stagiaire> st = stagiaireRepository.findByType(t);
		for (Stagiaire s : st) {
			System.out.println(s);
		}
	}

	@Test
	public void findByTypeIdType() {
		List<Stagiaire> st = stagiareService.findByTypeIdType(1L);
		for (Stagiaire s : st) {
			System.out.println(s);
		}
	}
}
