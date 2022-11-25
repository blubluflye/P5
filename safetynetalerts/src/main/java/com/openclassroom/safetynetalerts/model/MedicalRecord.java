package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;

@Data
public class MedicalRecord {
	
	private String firstName;
	private String lastName;
	private String birthdate;
	private List<String> medications;
	private List<String> allergies;
	
	public void update(MedicalRecord medRecord) {
		this.birthdate = medRecord.getBirthdate();
		this.medications = medRecord.getMedications();
		this.allergies = medRecord.getAllergies();
	}
}
