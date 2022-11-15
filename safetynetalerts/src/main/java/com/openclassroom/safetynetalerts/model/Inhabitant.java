package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;

@Data
public class Inhabitant {
	private String firstName;
	private String lastName;
	private int age;
	private List<String> medications;
	private List<String> allergies;
}
