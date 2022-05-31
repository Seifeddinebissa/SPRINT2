package com.seif.stagiaires.services;

import java.util.List;

import com.seif.stagiaires.entities.Role;

public interface RoleService {

	List <Role> findAll();
	Role findByRole(String role);
}
