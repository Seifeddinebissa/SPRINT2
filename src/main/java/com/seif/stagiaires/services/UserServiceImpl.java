package com.seif.stagiaires.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.seif.stagiaires.entities.Role;
import com.seif.stagiaires.entities.User;
import com.seif.stagiaires.repositorys.RoleRepository;
import com.seif.stagiaires.repositorys.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User e) {
		return userRepository.save(e);
	}
	
	

	@Override
	public User updateUser(User e) {
		return userRepository.save(e);
	}

	@Override
	public void deleteUser(User e) {
		userRepository.delete(e);
		
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);		
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public Page<User> getAllUsersParPage(int page, int size) {
		return userRepository.findAll(PageRequest.of(page, size));
	}
	


	@Override
	public User findUserByUsername(String username) {	
		return userRepository.findByUsername(username);
	}



}
