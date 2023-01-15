package com.openclassroom.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.safetynetalerts.model.Fire;
import com.openclassroom.safetynetalerts.service.FireService;

@RestController
public class FireController {
	@Autowired
	private FireService fireService;
	
	public FireController(FireService fireService) {
		this.fireService = fireService;
	}
	
	@GetMapping("/fire")
	public Fire fire(@RequestParam String address) {
		return fireService.fire(address);
	}

}