package com.seif.stagiaires.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seif.stagiaires.entities.Role;
import com.seif.stagiaires.entities.Type;
import com.seif.stagiaires.entities.User;
import com.seif.stagiaires.repositorys.RoleRepository;
import com.seif.stagiaires.security.SecurityConfig;
import com.seif.stagiaires.services.RoleService;
import com.seif.stagiaires.services.UserService;



@Controller
public class UserController {


	@Autowired
	UserService userService;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	
	@RequestMapping("/showCreateUser")
	public String showCreate(ModelMap modelMap) {
		
		List<Role> roles = roleService.findAll();
		User user = new User();
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("roles", roles);
		return "formUser";
	}
	
	

	
	
	@RequestMapping("/ListeUsers")
	public String listeUsers(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<User> users = userService.getAllUsersParPage(page, size);
		
		
		modelMap.addAttribute("users", users);
		modelMap.addAttribute("pages", new int[users.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeUser";
	}
	
	
	@RequestMapping("/saveUser")
	public String saveUser(@Valid User user, int s,boolean ed,
			 BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) return "formUser";
		
		
		SecurityConfig sec = new SecurityConfig();
		PasswordEncoder passwordEncoder = sec.passwordEncoder();
      	user.setPassword(passwordEncoder.encode(user.getPassword()));
     	user.setEnabled(ed);
     			
     	List<Role> roles= roleService.findAll();
     	   
     	Role r=roles.get(s -1);
     	List<Role> listR = new ArrayList<Role>();
     	listR.add(r);
     	user.setRoles(listR);
  
     	List<Role> list=user.getRoles();
     	
		userService.saveUser(user);
	 return "redirect:/ListeUsers";
	}
	
	@RequestMapping("/supprimerUser")
	public String supprimerUser(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "2") int size) {

		User user =userService.getUser(id);
		user.setRoles(null);
		userService.updateUser(user);
		userService.deleteUserById(id);
		Page<User> users = userService.getAllUsersParPage(page,size);
		modelMap.addAttribute("users", users);
		modelMap.addAttribute("pages", new int[users.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "ListeUsers";
	}
	
	
	@RequestMapping("/modifierUser")
	public String editerUser(@RequestParam("id") Long id, ModelMap modelMap) {
		
		User u = userService.getUser(id);
		List<Role> roles = roleService.findAll();
		modelMap.addAttribute("roles", roles);
		modelMap.addAttribute("user", u);
		modelMap.addAttribute("mode", "edit");
		return "formUser";
	}

	
	
	
}
