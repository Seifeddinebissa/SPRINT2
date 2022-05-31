package com.seif.stagiaires.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seif.stagiaires.entities.Stagiaire;
import com.seif.stagiaires.entities.Type;
import com.seif.stagiaires.services.StagiaireService;

@Controller
public class StagiaireController {

	@Autowired
	StagiaireService stagiaireService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Type> types = stagiaireService.getAllTypes();
		Stagiaire s = new Stagiaire();
		Type ty = new Type();
		ty = types.get(0); 
		s.setType(ty);
		modelMap.addAttribute("types", types);
		modelMap.addAttribute("stagiaire", s);
		modelMap.addAttribute("mode", "new");
		return "formStagiaire";
	}

	@RequestMapping("/saveStagiaire")
	public String saveStagiaire(@Valid Stagiaire stagiaire, BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors())
			return "formStagiaire";
		
	 stagiaireService.saveStagiaire(stagiaire);
	return "redirect:/ListeStagiaires";
	}
	
	@RequestMapping("/ListeStagiaires")
	public String listeStagiaires(ModelMap modelMap, 
				@RequestParam(name = "page", defaultValue = "0") int page,
				@RequestParam(name = "size", defaultValue = "2") int size)
 {
		Page<Stagiaire> st = stagiaireService.getAllStagiairesParPage(page, size);
		List<Type> ts = stagiaireService.getAllTypes();
		modelMap.addAttribute("types", ts);
		modelMap.addAttribute("stagiaires", st);
		 modelMap.addAttribute("pages", new int[st.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeStagiaire";

	}
	

	
	@RequestMapping("/chercher")
	public String cherhcer(ModelMap modelMap, 
				@RequestParam(name = "page", defaultValue = "0") int page,
				@RequestParam(name = "size", defaultValue = "2") int size,@RequestParam("type") String nom)
 {
		System.out.println(nom);
		List<Type> ts = stagiaireService.getAllTypes();
		modelMap.addAttribute("types", ts);
		Page<Stagiaire> st = stagiaireService.getAllStagiairesByNomParPage(page, size,nom);
		modelMap.addAttribute("stagiaires", st);
		modelMap.addAttribute("pages", new int[st.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeStagiaire";

	}
	

	@RequestMapping("/chercherType")
	public String cherhcerType(ModelMap modelMap, 
				@RequestParam(name = "page", defaultValue = "0") int page,
				@RequestParam(name = "size", defaultValue = "2") int size,@RequestParam("type") Long id)
 {
		System.out.println(id);
		List<Type> ts = stagiaireService.getAllTypes();
		modelMap.addAttribute("types", ts);
		Page<Stagiaire> st = stagiaireService.getAllStagiairesByTypeParPage(page, size,id);
		modelMap.addAttribute("stagiaires", st);
		 modelMap.addAttribute("pages", new int[st.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeStagiaire";

	}

	
	
	@RequestMapping("/supprimerStagiaire")
	public String supprimerStagiaire(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		stagiaireService.deleteStagiaireById(id);
		Page<Stagiaire> st = stagiaireService.getAllStagiairesParPage(page, size);
		modelMap.addAttribute("stagiaires", st);
		modelMap.addAttribute("pages", new int[st.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeStagiaire";
	}
	
	@RequestMapping("/modifierStagiaire")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Stagiaire s= stagiaireService.getStagiaire(id);
	List<Type> ty = stagiaireService.getAllTypes();
	modelMap.addAttribute("types", ty);
	modelMap.addAttribute("stagiaire", s);
	modelMap.addAttribute("mode", "edit");
	return "formStagiaire";
	}


}
