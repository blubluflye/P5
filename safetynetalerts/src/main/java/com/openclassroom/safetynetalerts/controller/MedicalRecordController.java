package com.openclassroom.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.safetynetalerts.model.MedicalRecord;
import com.openclassroom.safetynetalerts.service.MedicalRecordService;

@RestController
public class MedicalRecordController {
	
	@Autowired
	private MedicalRecordService medicalRecordService;
	
	@PostMapping("/medicalRecord")
	public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordService.add(medicalRecord);
	}
	
	@PutMapping("/medicalRecord")
	public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordService.update(medicalRecord);
	}

	@DeleteMapping("/medicalRecord")
	public void deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
		medicalRecordService.delete(firstName, lastName);
	}
}