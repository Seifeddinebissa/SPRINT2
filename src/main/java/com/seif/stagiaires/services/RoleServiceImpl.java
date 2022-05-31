package com.seif.stagiaires.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seif.stagiaires.entities.Role;
import com.seif.stagiaires.repositorys.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findByRole(String role) {
		return roleRepository.findByRole(role);
	}

}
