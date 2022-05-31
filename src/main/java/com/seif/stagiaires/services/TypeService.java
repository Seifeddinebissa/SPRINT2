package com.seif.stagiaires.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.seif.stagiaires.entities.Type;



public interface TypeService {

	Type saveType(Type p);
	Type updateType(Type p);
	void deleteType(Type p);
	void deleteTypeById(Long id);
	Type getType(Long id);
	List<Type> getAllTypes();
	Page<Type> getAllTypesParPage(int page, int size);
}
