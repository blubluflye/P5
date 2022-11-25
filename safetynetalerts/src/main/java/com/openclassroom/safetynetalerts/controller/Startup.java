package com.openclassroom.safetynetalerts.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.safetynetalerts.model.Firestation;
import com.openclassroom.safetynetalerts.model.NetFile;
import com.openclassroom.safetynetalerts.repository.FirestationRepository;
import com.openclassroom.safetynetalerts.repository.MedicalRecordRepository;
import com.openclassroom.safetynetalerts.repository.PersonRepository;
import com.openclassroom.safetynetalerts.service.ChildAlertAddressService;
import com.openclassroom.safetynetalerts.service.CommunityEmailService;
import com.openclassroom.safetynetalerts.service.FireService;
import com.openclassroom.safetynetalerts.service.FirestationService;
import com.openclassroom.safetynetalerts.service.FloodStationService;
import com.openclassroom.safetynetalerts.service.PeopleFromFirestationService;
import com.openclassroom.safetynetalerts.service.PersonInfoService;
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
	@Autowired
	FireService service4;
	@Autowired
	FloodStationService service5;
	@Autowired
	PersonInfoService service6;
	@Autowired
	CommunityEmailService service7;
	@Autowired
	FirestationService firestationService;
	
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
		System.out.println();
		System.out.println(service4.fire("947 E. Rose Dr"));
		System.out.println();
		System.out.println(service5.floodStation(1));
		System.out.println();
		System.out.println(service6.personInfo());
		System.out.println();
		System.out.println(service7.communityEmail("Culver"));
		Firestation firestation = new Firestation();
		String address = "5 rue du bourg";
		firestation.setAddress(address);
		firestation.setStation(1);
		firestationService.add(firestation);
		List<Firestation> fList = firestationRepository.getAll();
		firestation = fList.get(fList.size() - 1);
		System.out.println(firestation);
	}

}
