package com.openclassroom.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.safetynetalerts.model.PhoneAlert;
import com.openclassroom.safetynetalerts.service.PhoneAlertService;

@RestController
public class PhoneAlertController {
	
	@Autowired
	private PhoneAlertService phoneAlertService;
	
	public PhoneAlertController(PhoneAlertService phoneAlertService) {
		this.phoneAlertService = phoneAlertService;
	}

	@GetMapping("/phoneAlert")
	public PhoneAlert phoneAlert(@RequestParam int firestation) {
		return phoneAlertService.phoneAlert(firestation);
	}
}
