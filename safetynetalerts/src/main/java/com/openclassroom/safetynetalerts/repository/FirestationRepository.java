package com.openclassroom.safetynetalerts.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import com.openclassroom.safetynetalerts.model.Firestation;

@Component
public class FirestationRepository {
	List<Firestation> firestations;
	
	public void save(List<Firestation> stations) {
		this.firestations = stations;
	}

	public List<Firestation> getAll() {
		return firestations;
	}
}
