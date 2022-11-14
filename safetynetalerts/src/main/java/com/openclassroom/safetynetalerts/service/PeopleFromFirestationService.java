package com.openclassroom.safetynetalerts.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.Firestation;
import com.openclassroom.safetynetalerts.model.MedicalRecord;
import com.openclassroom.safetynetalerts.model.People;
import com.openclassroom.safetynetalerts.repository.FirestationRepository;
import com.openclassroom.safetynetalerts.model.PeopleFromFirestation;
import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.repository.MedicalRecordRepository;
import com.openclassroom.safetynetalerts.repository.PersonRepository;

@Service
public class PeopleFromFirestationService {
	@Autowired
    private FirestationRepository firestationRepository ;
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	@Autowired
	private PersonRepository personRepository;
	
	public PeopleFromFirestation firestation(int stationNumber) {
		PeopleFromFirestation result = new PeopleFromFirestation();
		List<People> peopleList = new ArrayList<People>();
		List<String> listAddressForStation = new ArrayList<String>();
		for(Firestation fstation : firestationRepository.getAll()) {
			if (fstation.getStation() == stationNumber)
				listAddressForStation.add(fstation.getAddress());
		}
		int adult = 0;
		int children = 0;
		for(Person person : personRepository.getAll()) {
			if (listAddressForStation.contains(person.getAddress())) {
				//check age to add +1 to adult or children
				  //find the medical record of this person
				DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDate birthdate = null;
				
				for (MedicalRecord medic : medicalRecordRepository.getAll()) {

					if (medic.getFirstName().equals(person.getFirstName()) && medic.getLastName().equals(person.getLastName())) {
						birthdate = LocalDate.parse(medic.getBirthdate(), customFormatter);
						break;
					}
				}
				LocalDate currentDate = LocalDate.now();
				if (birthdate != null) {
					if (currentDate.getYear() - birthdate.getYear() < 18)
						children++;
					else
						adult++;
				}
				//create new people to add to result
				People people = new People();
				people.setFirstName(person.getFirstName());
				people.setLastName(person.getLastName());
				people.setAddress(person.getAddress());
				people.setPhone(person.getPhone());
				peopleList.add(people);
			}
		}
		result.setAdultNumber(adult);
		result.setChildrenNumber(children);
		result.save(peopleList);
		return result;
	} 
}
