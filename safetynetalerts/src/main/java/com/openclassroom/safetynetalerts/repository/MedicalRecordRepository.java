package com.openclassroom.safetynetalerts.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.openclassroom.safetynetalerts.model.MedicalRecord;

@Component
public class MedicalRecordRepository {
	List<MedicalRecord> medicalRecords;
	
	public void save(List<MedicalRecord> records) {
		this.medicalRecords = List.copyOf(records);
	}

	public List<MedicalRecord> getAll() {
		return List.copyOf(medicalRecords);
	}

	public MedicalRecord add(MedicalRecord medRecord) {
		if (medicalRecords.add(medRecord))
			return medRecord;
		return null;
	}

	public void delete(String firstName, String lastname) {
		for(MedicalRecord m: medicalRecords) {
			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastname))
				medicalRecords.remove(m);
		}
	}

	public MedicalRecord update(MedicalRecord medRecord) {
		for(MedicalRecord m: medicalRecords) {
			if (m.getFirstName().equals(medRecord.getFirstName()) && m.getLastName().equals(medRecord.getLastName())) {
				return m.update(medRecord);
			}
		}
		return null;
	}
}
