package com.openclassroom.safetynetalerts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.openclassroom.safetynetalerts.model.Firestation;
import com.openclassroom.safetynetalerts.repository.FirestationRepository;
import com.openclassroom.safetynetalerts.service.FirestationService;


public class FirestationServiceTest {

	private static FirestationService firestationService;
	private static FirestationRepository firestationRepository;
	
	@BeforeAll
	 private static void setUp() {
		
	}
	
	@BeforeEach
	private void setUpPerTest() {		
		firestationRepository = new FirestationRepository();
	}
	
	@Test
	void addFirstFirestation() {
		Firestation firestation = new Firestation();
		String address = "5 rue du bourg";
		firestation.setAddress(address);
		firestation.setStation(1);
		firestationService.add(firestation);
		firestation = firestationRepository.getAll().get(0);
		assert(firestation.getAddress().equals(address));
		assertEquals(firestation.getStation(), 1);
	}
}
