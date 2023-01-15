package com.openclassroom.safetynetalerts;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.service.PersonService;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;
	

	
	@Test
	public void testCreatePerson() throws Exception {
		
		String firstName = "Pierre";
		String lastName = "Tailleur";
		String address = "12 rue du moulin";
		String city = "ville A";
		String zip = "zip";
		String phone = "0112141513";
		String email = "test@sfr.fr";
		Person person = new Person(firstName, lastName, address, city, zip, phone, email);
		
		mockMvc.perform(post("/person")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(person))
				).andExpect(status().isOk());
	}
	
	@Test
	public void testDeletePerson() throws Exception {
		mockMvc.perform(delete("/person")
				.queryParam("firstName", "Allison")
				.queryParam("lastName", "Boyd")).andExpect(status().isOk());
	}
	
	@Test
	public void testUpdatePerson() throws Exception {
		String firstName = "Allison";
		String lastName = "Boyd";
		String address = "12 rue du moulin";
		String city = "ville A";
		String zip = "zip";
		String phone = "0112141513";
		String email = "test@sfr.fr";
		Person person = new Person(firstName, lastName, address, city, zip, phone, email);
		mockMvc.perform(put("/person")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(person)))
				.andExpect(status().isOk());
	}
}
