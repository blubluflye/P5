package com.openclassroom.safetynetalerts.model;

import java.util.List;
import lombok.Data;

@Data
public class Group {
	private String address;
	List<Citizen> citizen;
}
