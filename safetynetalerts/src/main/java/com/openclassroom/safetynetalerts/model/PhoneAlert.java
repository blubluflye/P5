package com.openclassroom.safetynetalerts.model;

import java.util.List;
import lombok.Data;

@Data
public class PhoneAlert {
	List<String> phoneNumbers;
	public void save(List<String> phoneNumberList) {
		this.phoneNumbers = phoneNumberList;
	}
}
