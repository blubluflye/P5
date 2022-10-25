package com.openclassroom.safetynetalerts.model;

import lombok.Data;

@Data
public class Citizen {
	private String firstName;
	private String lastName;
	private String phone;
	private int age;
	private String[] medications;
	private String[] allergies;
}
