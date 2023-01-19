package com.openclassroom.safetynetalerts.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@Data
@Setter(onMethod_ = @SuppressFBWarnings({"EI_EXPOSE_REP2","EI_EXPOSE_REP"}))
@Getter(onMethod_ = @SuppressFBWarnings({"EI_EXPOSE_REP2","EI_EXPOSE_REP"}))
public class People {
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
}
