package com.seif.stagiaires.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seif.stagiaires.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRole(String role);
	Optional<Role> findById(Long id);
}
