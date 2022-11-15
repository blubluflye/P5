package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;

@Data
public class PersonsInfo {
	List<PersonInfo> personsInfo;
	
	public void save(List<PersonInfo> listPersonInfo) {
		this.personsInfo = listPersonInfo;
	}
}
