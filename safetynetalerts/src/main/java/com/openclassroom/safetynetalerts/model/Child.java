package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;

@Data
public class Child {
	private String firstName;
	private String lastName;
	private String age;
	List<People> familyMembers;
}
