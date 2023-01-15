package com.openclassroom.safetynetalerts;

import java.util.Collections;

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
import com.openclassroom.safetynetalerts.model.MedicalRecord;
import com.openclassroom.safetynetalerts.service.MedicalRecordService;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicalRecordControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MedicalRecordService medicalRecordService;
	
	@Test
	public void testCreateMedicalRecordTest() throws Exception{
		MedicalRecord medicalRecord;
		medicalRecord = new MedicalRecord();
		medicalRecord.setAllergies(Collections.emptyList());
		medicalRecord.setMedications(Collections.emptyList());
		medicalRecord.setBirthdate("12/01/15");
		medicalRecord.setFirstName("Jeremy");
		medicalRecord.setLastName("Boucher");
		
		mockMvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(medicalRecord))
				).andExpect(status().isOk());
	}
	
	@Test
	public void testDeleteMedicalRecordTest() throws Exception{
		mockMvc.perform(delete("/medicalRecord")
				.queryParam("firstName", "Allison")
				.queryParam("lastName", "Boyd")).andExpect(status().isOk());
	}

	@Test
	public void testUpdateMedicalRecordTest() throws Exception{
		MedicalRecord medicalRecord;
		medicalRecord = new MedicalRecord();
		medicalRecord.setAllergies(Collections.emptyList());
		medicalRecord.setMedications(Collections.emptyList());
		medicalRecord.setBirthdate("12/01/15");
		medicalRecord.setFirstName("Allison");
		medicalRecord.setLastName("Boyd");
		
		mockMvc.perform(put("/medicalRecord").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(medicalRecord))
				).andExpect(status().isOk());
	}
}
