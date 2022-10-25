package com.openclassroom.safetynetalerts.model;


import java.util.List;

import lombok.Data;

@Data
public class NetFile {	
	private List<Person> persons;
	private List<Firestation> firestations;
	private List<MedicalRecord> medicalrecords;
}
