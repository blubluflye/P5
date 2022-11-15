package com.openclassroom.safetynetalerts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.safetynetalerts.model.CommunityEmail;
import com.openclassroom.safetynetalerts.model.Person;
import com.openclassroom.safetynetalerts.repository.PersonRepository;

@Service
public class CommunityEmailService {
	@Autowired
	private PersonRepository personRepository;
	
	public CommunityEmail communityEmail(String city) {
		List<String> emailList = new ArrayList<String>();
		for (Person person : personRepository.getAll()) {
			if (person.getCity().equals(city))
				emailList.add(person.getEmail());
		}
		CommunityEmail result = new CommunityEmail();
		result.save(emailList);
		return result;
	}
}
