package com.seif.stagiaires.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = passwordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		System.out.println("Passwors Encoded BCRYPT :******************** ");
		System.out.println(passwordEncoder.encode("123"));
	}


	@Override
	 protected void configure(HttpSecurity http) throws Exception {
	 http.authorizeRequests().antMatchers("/showCreate").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/saveStagiaire").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/saveType").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/showCreateUser").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/saveUser").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/ListeStagiaires").hasAnyRole("ADMIN","AGENT","USER");
	 http.authorizeRequests().antMatchers("/ListeTypes").hasAnyRole("ADMIN","AGENT","USER");
	 http.authorizeRequests().antMatchers("/ListeUsers").hasAnyRole("ADMIN","AGENT","USER");
	 http.authorizeRequests().antMatchers("/showCreateType").hasAnyRole("ADMIN","AGENT");
	 
	 http.authorizeRequests().antMatchers("/supprimerStagiaire","/modifierStagiaire").hasAnyRole("ADMIN");
	 http.authorizeRequests().antMatchers("/supprimerType","/modifierType").hasAnyRole("ADMIN");
	 http.authorizeRequests().antMatchers("/supprimerUser","/modifierUser").hasAnyRole("ADMIN");
	 http.exceptionHandling().accessDeniedPage("/accessDenied");

	 
	 
	
	 http.authorizeRequests().antMatchers("/login").permitAll();
	 http.authorizeRequests().antMatchers("/webjars/**").permitAll();
	 http.authorizeRequests().anyRequest().authenticated();
	 http.formLogin().loginPage("/login");
	 }
	
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

}