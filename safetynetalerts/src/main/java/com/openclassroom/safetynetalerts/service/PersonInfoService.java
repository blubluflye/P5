package com.openclassroom.safetynetalerts.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.MedicalRecord;
import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.model.PersonInfo;
import com.openclassroom.safetynetalerts.model.PersonsInfo;
import com.openclassroom.safetynetalerts.repository.MedicalRecordRepository;
import com.openclassroom.safetynetalerts.repository.PersonRepository;

@Service
public class PersonInfoService {
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	@Autowired
	private PersonRepository personRepository;
	
	public PersonsInfo personInfo(String firstName, String lastName) {
		PersonsInfo result = new PersonsInfo();
		List<PersonInfo> listPersonInfo= new ArrayList<PersonInfo>();
		for (Person p : personRepository.getAll()) {			
			if(p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)){
				PersonInfo pInfo = new PersonInfo();
				pInfo.setFirstName(p.getFirstName());
				pInfo.setLastName(p.getLastName());
				pInfo.setAddress(p.getAddress());
				pInfo.setEmail(p.getEmail());
				//go search other information in medicalRecordRepo about this person info
				for (MedicalRecord m : medicalRecordRepository.getAll()) {
					if (m.getFirstName().equals(p.getFirstName()) && m.getLastName().equals(p.getLastName())) {
						pInfo.setAllergies(m.getAllergies());
						pInfo.setMedications(m.getMedications());
						//compute age from birth date into integer
						DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						LocalDate birthdate = LocalDate.parse(m.getBirthdate(), customFormatter);
						LocalDate currentDate = LocalDate.now();
						pInfo.setAge(currentDate.getYear() - birthdate.getYear());
					}
				}
				listPersonInfo.add(pInfo);
			}
		}
		result.save(listPersonInfo);
		return result ;
	}
}
