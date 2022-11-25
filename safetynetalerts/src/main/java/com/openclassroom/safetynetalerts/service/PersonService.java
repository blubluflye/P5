package com.openclassroom.safetynetalerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public void add(Person person) {
		personRepository.add(person);
	}
	
	public void delete(String firstName, String Lastname) {
		personRepository.delete(firstName, Lastname);
	}
	
	public void update(Person person) {
		personRepository.update(person);
	}
}
