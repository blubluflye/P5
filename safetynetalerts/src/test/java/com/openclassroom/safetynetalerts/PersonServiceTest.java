package com.openclassroom.safetynetalerts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.repository.PersonRepository;
import com.openclassroom.safetynetalerts.service.PersonService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@InjectMocks
	private PersonService personService;
	@Mock
	private static PersonRepository personRepository;
		
	static Person person;
	
	@BeforeAll
	 private static void setUp() {
	}
	
	@BeforeEach
	private void setUpPerTest() {
		String firstName = "Pierre";
		String lastName = "Tailleur";
		String address = "12 rue du moulin";
		String city = "ville A";
		String zip = "zip";
		String phone = "0112141513";
		String email = "test@sfr.fr";
		person = new Person(firstName, lastName, address, city, zip, phone, email);
	}
	
	@Test
	void addPerson() {
		given(personRepository.add(person)).willReturn(person);
		Person result = personService.add(person);
		//check result
		assertThat(result).isNotNull();
	}
	
	@Test
	void deletePerson() {
		willDoNothing().given(personRepository).delete(person.getFirstName(), person.getLastName());
		personService.delete(person.getFirstName(), person.getLastName());
		verify(personRepository, times(1)).delete(person.getFirstName(), person.getLastName());
	}
	
	@Test
	void updatePerson() {
		given(personRepository.update(person)).willReturn(person);
		Person result = personService.update(person);
		//check result
		assertThat(result).isNotNull();
	}
	
}
