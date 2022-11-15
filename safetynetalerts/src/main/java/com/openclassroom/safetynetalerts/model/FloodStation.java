package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;

@Data
public class FloodStation {
	List<Group> peopleByAddress;

	public void save(List<Group> listPeopleByAddress) {
		this.peopleByAddress = listPeopleByAddress;
	}
}
