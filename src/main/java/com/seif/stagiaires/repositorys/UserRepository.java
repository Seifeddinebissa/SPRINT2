package com.seif.stagiaires.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seif.stagiaires.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername (String username);

}
