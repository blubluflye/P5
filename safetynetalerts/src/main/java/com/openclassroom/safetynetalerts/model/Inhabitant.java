package com.openclassroom.safetynetalerts.model;

import lombok.Data;

@Data
public class Inhabitant {
	private String firstName;
	private String lastName;
	private int age;
	private String[] medications;
	private String[] allergies;
}
