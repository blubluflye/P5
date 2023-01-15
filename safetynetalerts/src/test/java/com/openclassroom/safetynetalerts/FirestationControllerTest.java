package com.openclassroom.safetynetalerts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.safetynetalerts.model.Firestation;
import com.openclassroom.safetynetalerts.service.FirestationService;


@SpringBootTest
@AutoConfigureMockMvc
public class FirestationControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FirestationService firestationService;
	

	@Test
	public void testCreateFirestation() throws Exception {
		Firestation firestation = new Firestation();
		firestation.setAddress("5 rue du dentiste");
		firestation.setStation(5);
		mockMvc.perform(post("/firestation")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(firestation)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testDeleteFirestation() throws Exception {
		mockMvc.perform(delete("/firestation")
						.queryParam("address", "489 Manchester St")
						.queryParam("stationNumber", "4"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testUpdateFirestation() throws Exception {
		mockMvc.perform(put("/firestation")
				.queryParam("address", "489 Manchester St")
				.queryParam("stationNumber", "5"))
				.andExpect(status().isOk());
	}
}
