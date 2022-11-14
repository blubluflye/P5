package com.openclassroom.safetynetalerts.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.openclassroom.safetynetalerts.model.MedicalRecord;

@Component
public class MedicalRecordRepository {
	List<MedicalRecord> medicalRecords;
	
	public void save(List<MedicalRecord> records) {
		this.medicalRecords = records;
	}

	public List<MedicalRecord> getAll() {
		return medicalRecords;
	}
}
