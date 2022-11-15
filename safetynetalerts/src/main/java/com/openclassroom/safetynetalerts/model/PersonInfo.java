package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;

@Data
public class PersonInfo {
	private String firstName;
	private String lastName;
	private String address;
	private int age;
	private String email;
	private List<String> medications;
	private List<String> allergies;
}
