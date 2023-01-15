package com.openclassroom.safetynetalerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.repository.PersonRepository;

import lombok.Data;

@Data
@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public Person add(Person person) {
		return personRepository.add(person);
	}
	
	public void delete(String firstName, String Lastname) {
		personRepository.delete(firstName, Lastname);
	}
	
	public Person update(Person person) {
		return personRepository.update(person);
	}
}
