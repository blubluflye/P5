package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;

@Data
public class Child {
	private String firstName;
	private String lastName;
	private int age;
	List<People> familyMembers;
	
	public void save(List<People> peopleList) {
		this.familyMembers = peopleList;
	}
}
