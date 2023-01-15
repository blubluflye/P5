package com.openclassroom.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.safetynetalerts.model.CommunityEmail;
import com.openclassroom.safetynetalerts.service.CommunityEmailService;

@RestController
public class CommunityEmailController {

	@Autowired
	private CommunityEmailService communityEmailService;
	
	public CommunityEmailController(CommunityEmailService communityEmailService) {
		this.communityEmailService = communityEmailService;
	}
	
	@GetMapping("/communityEmail")
	public CommunityEmail communityEmail(@RequestParam String city) {
		return communityEmailService.communityEmail(city);
	}
}