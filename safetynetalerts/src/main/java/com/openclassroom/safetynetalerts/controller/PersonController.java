package com.openclassroom.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = new PersonService();
		this.personService.setPersonRepository(personService.getPersonRepository());
	}
	
	/**
	 * Create - Add a new person
	 * @param person An object Person
	 * @return The Person object saved
	 */
	@PostMapping("/person")
	public Person createPerson(@RequestBody Person person) {
		return personService.add(person);
	}
	
	/**
	 * Delete - Delete a person
	 * @param firstName - The firstName of the person to delete
	 * @param lastName - The lastName of the person to delete
	 */
	@DeleteMapping("/person")
	public void deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
			personService.delete(firstName, lastName);
	}
	
	/**
	 * Update - update a person info
	 * @param person An object Person
	 * @return The Person object saved
	 */
	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person) {
		return personService.update(person);
	}
	
}
