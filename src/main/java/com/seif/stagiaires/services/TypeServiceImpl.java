package com.seif.stagiaires.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.seif.stagiaires.entities.Type;
import com.seif.stagiaires.repositorys.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService{

	@Autowired 
	TypeRepository typeRepository;
	
	@Override
	public Type saveType(Type p) {
		return typeRepository.save(p);
	}

	@Override
	public Type updateType(Type p) {
		return typeRepository.save(p);
	}

	@Override
	public void deleteType(Type p) {
		typeRepository.delete(p);
	}

	@Override
	public void deleteTypeById(Long id) {
		typeRepository.deleteById(id);
	}

	@Override
	public Type getType(Long id) {
		return typeRepository.findById(id).get();
	}

	@Override
	public List<Type> getAllTypes() {
		return typeRepository.findAll();
	}

	@Override
	public Page<Type> getAllTypesParPage(int page, int size) {
		return typeRepository.findAll(PageRequest.of(page, size));
	}

}
