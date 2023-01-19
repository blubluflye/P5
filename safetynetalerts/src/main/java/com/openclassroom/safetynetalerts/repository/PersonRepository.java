package com.openclassroom.safetynetalerts.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import com.openclassroom.safetynetalerts.model.Person;

@Component
public class PersonRepository {
	 private List<Person> persons;
	 
	 public Person add(Person person) {
		 if (persons.add(person)) {
			 return person;
		 }
		 return null;
	 }
	 
	 public void delete(String firstName, String Lastname) {
		 for (Person p : persons) {
			 if (p.getFirstName().equals(firstName) && p.getLastName().equals(Lastname))
				 persons.remove(p);
		 }
	 }
	 
	 public void save(List<Person> personList) {
			this.persons = List.copyOf(personList);
		}

		public  List<Person> getAll() {
			return List.copyOf(persons);
		}

		public Person update(Person person) {
			 for (Person p : persons) {
				 if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) {
					 p.setAddress(person.getAddress());
					 p.setCity(person.getCity());
					 p.setEmail(person.getEmail());
					 p.setPhone(person.getPhone());
					 p.setZip(person.getZip());
					 return p;
				 }	
			 }
			 return null;
		}
}
