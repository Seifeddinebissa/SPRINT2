package com.seif.stagiaires.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.seif.stagiaires.entities.Role;
import com.seif.stagiaires.entities.User;

public interface UserService {

    List <User> findAll();
	
	User saveUser(User e);
	User updateUser(User e);
	void deleteUser(User e);
	void deleteUserById(Long id);
	User getUser(Long id);
	Page<User> getAllUsersParPage(int page, int size);
	User findUserByUsername (String username);

}
