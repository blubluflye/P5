package com.openclassroom.safetynetalerts.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@Data
@Setter(onMethod_ = @SuppressFBWarnings({"EI_EXPOSE_REP2","EI_EXPOSE_REP"}))
@Getter(onMethod_ = @SuppressFBWarnings({"EI_EXPOSE_REP2","EI_EXPOSE_REP"}))
public class Person {	

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;
	
	public Person() {
		
	}
	
	public Person(String firstName2, String lastName2, String address2, String city2, String zip2, String phone2,
			String email2) {
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.address = address2;
		this.city = city2;
		this.zip = zip2;
		this.phone = phone2;
	}
}
