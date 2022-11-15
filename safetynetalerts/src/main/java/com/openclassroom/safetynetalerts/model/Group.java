package com.openclassroom.safetynetalerts.model;

import java.util.List;
import lombok.Data;

@Data
public class Group {
	private String address;
	List<HouseMember> citizens;
	
	public void save(List<HouseMember> listPeopleAtThisAddress) {
		this.citizens = listPeopleAtThisAddress;
	}
}
