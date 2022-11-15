package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;

@Data
public class CommunityEmail {
	List<String> mailList;

	public void save(List<String> emailList) {
		this.mailList = emailList;
	}
}
