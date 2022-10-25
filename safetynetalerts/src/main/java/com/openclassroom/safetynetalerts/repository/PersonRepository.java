package com.openclassroom.safetynetalerts.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.openclassroom.safetynetalerts.model.Person;

@Repository
public interface PersonRepository extends List<Person>{

}
