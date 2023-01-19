package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@Data
@Setter(onMethod_ = @SuppressFBWarnings({"EI_EXPOSE_REP2","EI_EXPOSE_REP"}))
@Getter(onMethod_ = @SuppressFBWarnings({"EI_EXPOSE_REP2","EI_EXPOSE_REP"}))
public class PersonInfo {
	private String firstName;
	private String lastName;
	private String address;
	private int age;
	private String email;
	private List<String> medications;
	private List<String> allergies;
}
