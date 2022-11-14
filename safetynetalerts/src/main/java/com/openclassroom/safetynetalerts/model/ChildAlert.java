package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;

@Data
public class ChildAlert {
	List<Child> children;

	public void save(List<Child> childList) {
		this.children = childList;
	}
}
