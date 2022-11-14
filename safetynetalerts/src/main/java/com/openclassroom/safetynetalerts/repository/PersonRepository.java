package com.openclassroom.safetynetalerts.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import com.openclassroom.safetynetalerts.model.Person;

@Component
public class PersonRepository {
	 private List<Person> persons;
	 
	 public void save(List<Person> personList) {
			this.persons = personList;
		}

		public  List<Person> getAll() {
			return persons;
		}
}
