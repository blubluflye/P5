package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;

@Data
public class PeopleFromFirestation {
	List<People> people;
	int adultNumber;
	int childrenNumber;
}
