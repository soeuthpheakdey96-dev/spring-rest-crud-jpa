package com.learning.dev.spring.myfirstapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dev.spring.myfirstapp.dao.CoustomerRepository;
import com.learning.dev.spring.myfirstapp.entity.Coustomer;

import jakarta.transaction.Transactional;
import tools.jackson.databind.json.JsonMapper;

@Service
public class CoustomerServicemlpl implements CoustomerService{

	
	private CoustomerRepository coustomerRepository;
	
	private JsonMapper jsonMapper;
	
	 @Autowired
	public CoustomerServicemlpl(CoustomerRepository coustomerRepository,JsonMapper jsonMapper) {
		
		this.coustomerRepository = coustomerRepository;
		
		this.jsonMapper = jsonMapper;
	}
	@Override
	public List<Coustomer> findAll() {
		
		return coustomerRepository.findAll();
	}

	@Override
	public Coustomer findById(int id) {
		Optional<Coustomer>result = coustomerRepository.findById(id);
		
		Coustomer coustomerRepository = null;
		if(result.isPresent()) {
			coustomerRepository = result.get();
		}
		else {
			//System.out.println("Did not find coustomer id"+id);
			throw new RuntimeException("Did not find coustomer id - " + id);
		}
		return coustomerRepository;
	}

	@Override
	@Transactional
	public Coustomer save(Coustomer emp) {
		
		return coustomerRepository.save(emp);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		coustomerRepository.deleteById(theId);
	}

}

