package com.openclassroom.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.safetynetalerts.model.Firestation;
import com.openclassroom.safetynetalerts.service.FirestationService;

@RestController
public class FirestationController {

	@Autowired
	private FirestationService firestationService;
	
	@PostMapping("/firestation")
	public Firestation createFirestation(Firestation firestation) {
		return firestationService.add(firestation);
	}
	
	@PutMapping("/firestation")
	public Firestation updateFirestation(@RequestParam String address, @RequestParam int stationNumber) {
		return firestationService.update(address, stationNumber);
	}
	
	@DeleteMapping("/firestation")
	public void  deleteFirestation(@RequestParam String address, @RequestParam int stationNumber) {
		firestationService.delete(address, stationNumber);
	}
}
