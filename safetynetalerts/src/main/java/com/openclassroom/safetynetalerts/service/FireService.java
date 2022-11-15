package com.openclassroom.safetynetalerts.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.Fire;
import com.openclassroom.safetynetalerts.model.Firestation;
import com.openclassroom.safetynetalerts.model.Inhabitant;
import com.openclassroom.safetynetalerts.model.MedicalRecord;
import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.repository.FirestationRepository;
import com.openclassroom.safetynetalerts.repository.MedicalRecordRepository;
import com.openclassroom.safetynetalerts.repository.PersonRepository;

@Service
public class FireService {
	@Autowired
    private FirestationRepository firestationRepository ;
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	@Autowired
	private PersonRepository personRepository;
	
	public Fire fire(String address) {
		Fire result = new Fire();
		int firestationNumber = -1;
		List<Inhabitant> peoples = new ArrayList<Inhabitant>();
		for (Firestation f : firestationRepository.getAll()) {
			if (f.getAddress().equals(address)) {
				firestationNumber = f.getStation();
				break;
			}
		}
		//for people at the good address create a new Inhabitant to add to peoples
		for (Person person : personRepository.getAll()) {
			//check if same address
			if (person.getAddress().equals(address)) {
				Inhabitant inhabitant = new Inhabitant();
				inhabitant.setFirstName(person.getFirstName());
				inhabitant.setLastName(person.getLastName());
				//need to get medicalRecord for people age, medications and allergies
				for (MedicalRecord m : medicalRecordRepository.getAll()) {
					if (m.getFirstName().equals(person.getFirstName()) && m.getLastName().equals(person.getLastName())) {
						inhabitant.setAllergies(m.getAllergies());
						inhabitant.setMedications(m.getMedications());
						//compute age from birth date into int
						DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						LocalDate birthdate = LocalDate.parse(m.getBirthdate(), customFormatter);
						LocalDate currentDate = LocalDate.now();
						inhabitant.setAge(currentDate.getYear() - birthdate.getYear());
					}
				}
				peoples.add(inhabitant);
			}
		}
		result.setFirestation(firestationNumber);
		result.setInhabitants(peoples);
		return result;	
	}
}
