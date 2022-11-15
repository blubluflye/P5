package com.openclassroom.safetynetalerts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.Firestation;
import com.openclassroom.safetynetalerts.model.People;
import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.model.PhoneAlert;
import com.openclassroom.safetynetalerts.repository.FirestationRepository;
import com.openclassroom.safetynetalerts.repository.PersonRepository;

@Service
public class PhoneAlertService {
	@Autowired
    private FirestationRepository firestationRepository;
	@Autowired
	private PersonRepository personRepository;
	
	public PhoneAlert phoneAlert(int firestation) {
		PhoneAlert phoneAlert = new PhoneAlert();
		List<String> phoneList = new ArrayList<String>();
		List<String> listAddressForStation = new ArrayList<String>();
		for(Firestation fstation : firestationRepository.getAll()) {
			if (fstation.getStation() == firestation)
				listAddressForStation.add(fstation.getAddress());
		}
		for(Person person : personRepository.getAll()) {
			if (listAddressForStation.contains(person.getAddress()))
				phoneList.add(person.getPhone());
		}
		phoneAlert.save(phoneList);
		return phoneAlert;
	}
}
