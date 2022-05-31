package com.seif.stagiaires.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seif.stagiaires.entities.Stagiaire;
import com.seif.stagiaires.entities.Type;
import com.seif.stagiaires.services.TypeService;

@Controller
public class TypeController {

	@Autowired
	TypeService typeService;
	
	@RequestMapping("/showCreateType")
	public String showCreate(ModelMap modelMap) {
		Type ty = new Type();
		modelMap.addAttribute("type", ty);
		modelMap.addAttribute("mode", "new");
		return "formType";
	}
	
	@RequestMapping("/saveType")
	public String saveType(@ModelAttribute("type") Type type) 
	{
		Type savetype = typeService.saveType(type);
		return "redirect:/ListeTypes";
	}
	
	@RequestMapping("/ListeTypes")
	public String listeTypes(ModelMap modelMap, 
				@RequestParam(name = "page", defaultValue = "0") int page,
				@RequestParam(name = "size", defaultValue = "2") int size)
 {
		Page<Type> t = typeService.getAllTypesParPage(page, size);
		modelMap.addAttribute("types", t);
		 modelMap.addAttribute("pages", new int[t.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeType";

	}
	
	@RequestMapping("/supprimerType")
	public String supprimerType(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		typeService.deleteTypeById(id);
		Page<Type> t = typeService.getAllTypesParPage(page, size);
		modelMap.addAttribute("types", t);
		modelMap.addAttribute("pages", new int[t.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeType";
	}
	
	@RequestMapping("/modifierType")
	public String editerType(@RequestParam("id") Long id, ModelMap modelMap) {
		Type t = typeService.getType(id);
		modelMap.addAttribute("type", t);
		modelMap.addAttribute("mode", "edit");
		return "formType";
	}

}
