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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
		given(medicalRecordRepository.add(medicalRecord)).willReturn(medicalRecord);
		MedicalRecord result = medicalRecordService.add(medicalRecord);
		//check result
		assertThat(result).isNotNull();
	}
	
	@Test
	void deleteMedicalRecord() {
		willDoNothing().given(medicalRecordRepository).delete(medicalRecord.getFirstName(), medicalRecord.getLastName());
		medicalRecordService.delete(medicalRecord.getFirstName(), medicalRecord.getLastName());
		verify(medicalRecordRepository, times(1)).delete(medicalRecord.getFirstName(), medicalRecord.getLastName());
	}

	@Test
	void updateMedicalRecord() {
		given(medicalRecordRepository.update(medicalRecord)).willReturn(medicalRecord);
		MedicalRecord result = medicalRecordService.update(medicalRecord);
		//check result
		assertThat(result).isNotNull();
	}
}
