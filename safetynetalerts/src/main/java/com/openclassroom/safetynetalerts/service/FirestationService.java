package com.openclassroom.safetynetalerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.Firestation;
import com.openclassroom.safetynetalerts.repository.FirestationRepository;

@Service
public class FirestationService {
	@Autowired
    private FirestationRepository firestationRepository;
	
	public Firestation add(Firestation firestation) {
		return firestationRepository.add(firestation);
	}
	
	public void delete(String address, int firestation) {
		firestationRepository.delete(address, firestation);
	}
	
	public Firestation update(String address, int newFirestation) {
		return firestationRepository.update(address, newFirestation);
	}
}
