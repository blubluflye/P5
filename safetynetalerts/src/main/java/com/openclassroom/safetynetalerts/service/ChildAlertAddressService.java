package com.openclassroom.safetynetalerts.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.Child;
import com.openclassroom.safetynetalerts.model.ChildAlert;
import com.openclassroom.safetynetalerts.model.MedicalRecord;
import com.openclassroom.safetynetalerts.model.People;
import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.repository.MedicalRecordRepository;
import com.openclassroom.safetynetalerts.repository.PersonRepository;

@Service
public class ChildAlertAddressService {
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	@Autowired
	private PersonRepository personRepository;
	
	public ChildAlert childAlert(String address) {
		ChildAlert result = new ChildAlert();
		List<Child> childList = new ArrayList<Child>();
		for(Person person : personRepository.getAll()) {
			//check if same address
			if (person.getAddress().equals(address)) {
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
					int age = currentDate.getYear() - birthdate.getYear();
					if (age < 18) {
						//create and add the new Child
						Child child = new Child();
						child.setFirstName(person.getFirstName());
						child.setLastName(person.getLastName());
						child.setAge(age);
						//now create the family member list of the child and fill it
						List<People> familyMembers = new ArrayList<People>();
						for(Person person2 : personRepository.getAll()) {
							//check if same address
							if (person2.getAddress().equals(address)) {
								if (person2.getLastName().equals(child.getLastName()) && !(person2.getFirstName().equals(child.getFirstName()))) {
									People familyMember = new People();
									familyMember.setAddress(person2.getAddress());
									familyMember.setFirstName(person2.getFirstName());
									familyMember.setLastName(person2.getLastName());
									familyMember.setPhone(person2.getPhone());
									familyMembers.add(familyMember);
								}
							}
						}
						child.save(familyMembers);
						//add the new child to the list
						childList.add(child);
					}	
				}
			}
		}
		result.save(childList);
		return result;
	}
}
