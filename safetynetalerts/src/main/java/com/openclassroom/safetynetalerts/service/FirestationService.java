package com.openclassroom.safetynetalerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.Firestation;
import com.openclassroom.safetynetalerts.repository.FirestationRepository;

@Service
public class FirestationService {
	@Autowired
    private FirestationRepository firestationRepository;
	
	public void add(Firestation firestation) {
		firestationRepository.add(firestation);
	}
	
	public void delete(Firestation firestation) {
		firestationRepository.delete(firestation);
	}
	
	public void update(String address, int newFirestation) {
		firestationRepository.update(address, newFirestation);
	}
}
