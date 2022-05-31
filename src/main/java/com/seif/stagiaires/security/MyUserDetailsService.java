package com.seif.stagiaires.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.seif.stagiaires.entities.User;
import com.seif.stagiaires.repositorys.UserRepository;

@Service
public class MyUserDetailsService  implements UserDetailsService {
	
@Autowired
UserRepository userRepository;
@Override
public UserDetails loadUserByUsername(String username) throws
UsernameNotFoundException {
User user = userRepository.findByUsername(username);
return new MyUserDetails(user);

 }
}