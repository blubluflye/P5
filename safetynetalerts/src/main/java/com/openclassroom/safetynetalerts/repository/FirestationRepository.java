package com.openclassroom.safetynetalerts.repository;

import java.util.ArrayList;
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

	public void add(Firestation firestation) {
		firestations.add(firestation);
	}

	public void delete(Firestation firestation) {
		firestations.remove(firestation);
	}

	public void update(String address, int newFirestation) {
		for (Firestation f: firestations) {
			if (f.getAddress().equals(address))
				f.setStation(newFirestation);
		}
	}
	
	public FirestationRepository() {
		this.firestations = new ArrayList<Firestation>();
	}
}
