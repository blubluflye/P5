package com.openclassroom.safetynetalerts.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.HouseMember;
import com.openclassroom.safetynetalerts.model.Firestation;
import com.openclassroom.safetynetalerts.model.FloodStation;
import com.openclassroom.safetynetalerts.model.Group;
import com.openclassroom.safetynetalerts.model.MedicalRecord;
import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.repository.FirestationRepository;
import com.openclassroom.safetynetalerts.repository.MedicalRecordRepository;
import com.openclassroom.safetynetalerts.repository.PersonRepository;

@Service
public class FloodStationService {
	@Autowired
    private FirestationRepository firestationRepository ;
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	@Autowired
	private PersonRepository personRepository;
	
	public FloodStation floodStation(int firestationNumber) {
		FloodStation result = new FloodStation();
		List<Group> peopleByAddress = new ArrayList<Group>();
		List<String> listAddressForStation = new ArrayList<String>();
		for(Firestation fstation : firestationRepository.getAll()) {
			if (fstation.getStation() == firestationNumber)
				listAddressForStation.add(fstation.getAddress());
		}
		for (String address : listAddressForStation) {
			Group group = new Group();
			group.setAddress(address);
			List<HouseMember> citizens = new ArrayList<HouseMember>();
			//fill the citizen list for this group
			for (Person p : personRepository.getAll()) {
				//check if he lives at the good address
				if (p.getAddress().equals(address)) {
					//create a new citizen with person information needed
					HouseMember houseMember = new HouseMember();
					houseMember.setFirstName(p.getFirstName());
					houseMember.setLastName(p.getLastName());
					houseMember.setPhone(p.getPhone());
					//go search other information in medicalRecordRepo about this person
					for (MedicalRecord m : medicalRecordRepository.getAll()) {
						if (m.getFirstName().equals(p.getFirstName()) && m.getLastName().equals(p.getLastName())) {
							houseMember.setAllergies(m.getAllergies());
							houseMember.setMedications(m.getMedications());
							//compute age from birth date into integer
							DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
							LocalDate birthdate = LocalDate.parse(m.getBirthdate(), customFormatter);
							LocalDate currentDate = LocalDate.now();
							houseMember.setAge(currentDate.getYear() - birthdate.getYear());
						}
					}
					//add him to the citizen List
					citizens.add(houseMember);
				}
				group.save(citizens);
			}
			//add this group in the Group List people by address
			peopleByAddress.add(group);
		}
		result.save(peopleByAddress);
		return result;
	}
}
