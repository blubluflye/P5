package com.openclassroom.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.safetynetalerts.model.ChildAlert;
import com.openclassroom.safetynetalerts.service.ChildAlertAddressService;

@RestController
public class ChildAlertAddressController {
	
	@Autowired
	private ChildAlertAddressService childAlertAddressService;
	
	public ChildAlertAddressController(ChildAlertAddressService childAlertAddressService) {
		this.childAlertAddressService = childAlertAddressService;
	}
	
	@GetMapping("/childAlert")
	public ChildAlert childAlert(@RequestParam String address) {
		return childAlertAddressService.childAlert(address);
	}

}
