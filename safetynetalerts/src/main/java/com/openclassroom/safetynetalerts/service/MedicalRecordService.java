package com.openclassroom.safetynetalerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.MedicalRecord;
import com.openclassroom.safetynetalerts.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	
	public MedicalRecord add(MedicalRecord MedRecord) {
		return medicalRecordRepository.add(MedRecord);
	}
	
	public void delete(String firstName, String Lastname) {
		medicalRecordRepository.delete(firstName, Lastname);
	}
	
	public MedicalRecord update(MedicalRecord MedRecord) {
		return medicalRecordRepository.update(MedRecord);
	}
}
