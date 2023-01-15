package com.openclassroom.safetynetalerts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.openclassroom.safetynetalerts.model.MedicalRecord;
import com.openclassroom.safetynetalerts.repository.MedicalRecordRepository;
import com.openclassroom.safetynetalerts.service.MedicalRecordService;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceTest {

	@InjectMocks
	private MedicalRecordService medicalRecordService;
	@Mock
	private static MedicalRecordRepository medicalRecordRepository;
	
	static MedicalRecord medicalRecord;
	
	@BeforeAll
	 private static void setUp() {
	}
	
	@BeforeEach
	private void setUpPerTest() {
		medicalRecord = new MedicalRecord();
		medicalRecord.setAllergies(Collections.emptyList());
		medicalRecord.setMedications(Collections.emptyList());
		medicalRecord.setBirthdate("12/01/15");
		medicalRecord.setFirstName("Jeremy");
		medicalRecord.setLastName("Boucher");
	}
	
	@Test
	void addMedicalRecord() {
		
	}
	
	@Test
	void deleteMedicalRecord() {
		
	}

	@Test
	void updateMedicalRecord() {
		
	}
}
