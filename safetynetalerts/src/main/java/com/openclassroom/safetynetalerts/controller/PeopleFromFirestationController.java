package com.openclassroom.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.safetynetalerts.model.PeopleFromFirestation;
import com.openclassroom.safetynetalerts.service.PeopleFromFirestationService;

@RestController
public class PeopleFromFirestationController {

	@Autowired
	private PeopleFromFirestationService peopleFromFirestationService;
	
	public PeopleFromFirestationController(PeopleFromFirestationService peopleFromFirestationService) {
		this.peopleFromFirestationService = peopleFromFirestationService;
	}
	
	@GetMapping("/firestation")
	public PeopleFromFirestation firestationController (@RequestParam int stationNumber) {
		return peopleFromFirestationService.firestation(stationNumber);
	}
}