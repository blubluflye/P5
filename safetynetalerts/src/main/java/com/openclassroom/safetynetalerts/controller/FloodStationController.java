package com.openclassroom.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.safetynetalerts.model.FloodStation;
import com.openclassroom.safetynetalerts.service.FloodStationService;

@RestController
public class FloodStationController {
	
	@Autowired
	private FloodStationService floodStationService;
	
	public FloodStationController(FloodStationService floodStationService) {
		this.floodStationService = floodStationService;
	}

	@GetMapping("/flood")
	public FloodStation flood(@RequestParam int stations) {
		return floodStationService.floodStation(stations);
	}
}