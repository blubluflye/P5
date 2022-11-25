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

	public void add(MedicalRecord medRecord) {
		medicalRecords.add(medRecord);
	}

	public void delete(String firstName, String lastname) {
		for(MedicalRecord m: medicalRecords) {
			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastname))
				medicalRecords.remove(m);
		}
	}

	public void update(MedicalRecord medRecord) {
		for(MedicalRecord m: medicalRecords) {
			if (m.getFirstName().equals(medRecord.getFirstName()) && m.getLastName().equals(medRecord.getLastName())) {
				m.update(medRecord);
			}
		}
	}
}
