package com.openclassroom.safetynetalerts.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.ChildAlert;
import com.openclassroom.safetynetalerts.model.MedicalRecord;
import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.repository.FirestationRepository;
import com.openclassroom.safetynetalerts.repository.MedicalRecordRepository;
import com.openclassroom.safetynetalerts.repository.PersonRepository;

@Service
public class ChildAlertAddressService {
	@Autowired
    private FirestationRepository firestationRepository ;
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	@Autowired
	private PersonRepository personRepository;
	
	public ChildAlert childAlert(String address) {
		ChildAlert result = new ChildAlert();
		for(Person person : personRepository.getAll()) {
			//check if same address
			if (person.getAddress() == address) {
				DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDate birthdate = null;
				//get birth date
				for (MedicalRecord medic : medicalRecordRepository.getAll()) {
					if (medic.getFirstName().equals(person.getFirstName()) && medic.getLastName().equals(person.getLastName())) {
						birthdate = LocalDate.parse(medic.getBirthdate(), customFormatter);
						break;
					}
				}
				LocalDate currentDate = LocalDate.now();
				if (birthdate != null) {
					//check if it's a kid
					if (currentDate.getYear() - birthdate.getYear() < 18) {
						//create and add the new Child
					}	
				}
			}
		}
		return result;
	}
}
