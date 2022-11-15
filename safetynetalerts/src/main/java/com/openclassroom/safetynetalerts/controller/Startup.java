package com.openclassroom.safetynetalerts.controller;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.safetynetalerts.model.NetFile;
import com.openclassroom.safetynetalerts.repository.FirestationRepository;
import com.openclassroom.safetynetalerts.repository.MedicalRecordRepository;
import com.openclassroom.safetynetalerts.repository.PersonRepository;
import com.openclassroom.safetynetalerts.service.ChildAlertAddressService;
import com.openclassroom.safetynetalerts.service.PeopleFromFirestationService;
import com.openclassroom.safetynetalerts.service.PhoneAlertService;

@Component
public class Startup implements CommandLineRunner{
	
	private String jsonFilePath = "C:\\Users\\Home\\OneDrive\\Bureau\\WorkPlaceOpenclassrooms\\P5\\safetynetalerts\\src\\main\\resources\\JsonTestFileGiven";

	@Autowired
	FirestationRepository firestationRepository;
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	PeopleFromFirestationService service;
	@Autowired
	ChildAlertAddressService service2;
	@Autowired
	PhoneAlertService service3;
	
	@Override
	public void run(String... args) throws Exception{
		//scan the JSON file
		Scanner sc = new Scanner(new File(jsonFilePath));
		sc.useDelimiter(System.getProperty("line.separator"));
		String json =  "";
		while (sc.hasNext())
			json += sc.next();
		sc.close();
		//transform the JSON string into a java object with all the informations
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false);
		NetFile netFile =  mapper.readValue(json, NetFile.class);
		//initialize and fill the 3 repositories with the informations from netFile
		firestationRepository.save(netFile.getFirestations()) ;
		personRepository.save(netFile.getPersons());
		medicalRecordRepository.save(netFile.getMedicalrecords());
		System.out.println(service.firestation(1));
		System.out.println();
		System.out.println(service2.childAlert("947 E. Rose Dr"));
		System.out.println();
		System.out.println(service3.phoneAlert(1));

	}

}
