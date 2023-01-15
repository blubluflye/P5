package com.openclassroom.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.safetynetalerts.model.PersonsInfo;
import com.openclassroom.safetynetalerts.service.PersonInfoService;

@RestController
public class PersonInfoController {

	@Autowired
	private PersonInfoService personInfoService;
	
	public PersonInfoController(PersonInfoService personInfoService) {
		this.personInfoService = personInfoService;
	}
	
	@GetMapping("/personInfo")
	public PersonsInfo name(@RequestParam String firstName, @RequestParam String lastName) {
		return personInfoService.personInfo(firstName, lastName);
	}
}
