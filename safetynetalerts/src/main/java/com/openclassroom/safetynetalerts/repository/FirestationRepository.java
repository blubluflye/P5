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

	public Firestation add(Firestation firestation) {
		if (firestations.add(firestation))
			return firestation;
		else
			return null;
	}

	public void delete(String address, int firestation) {
		for (Firestation f: firestations) {
			if (f.getAddress().equals(address) && f.getStation()==firestation)
				firestations.remove(firestation);
		}
	}

	public Firestation update(String address, int newFirestation) {
		for (Firestation f: firestations) {
			if (f.getAddress().equals(address)) {
				f.setStation(newFirestation);
				return f;
			}
		}
		return null;
	}
	
	public FirestationRepository() {
		this.firestations = new ArrayList<Firestation>();
	}
}
