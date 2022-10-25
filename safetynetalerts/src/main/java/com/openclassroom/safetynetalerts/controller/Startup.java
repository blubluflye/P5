package com.openclassroom.safetynetalerts.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.safetynetalerts.model.NetFile;

@Component
public class Startup implements CommandLineRunner{
	
	 private String jsonFilePath = "C:\\Users\\Home\\OneDrive\\Bureau\\WorkPlaceOpenclassrooms\\P5\\safetynetalerts\\src\\main\\resources\\JsonTestFileGiven";
	 
	@Override
	public void run(String... args) throws Exception{
		Scanner sc = new Scanner(new File(jsonFilePath));
		sc.useDelimiter(System.getProperty("line.separator"));
		String json =  "";
		while (sc.hasNext())
			json += sc.next();
		sc.close();

		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false);
		NetFile netFile =  mapper.readValue(json, NetFile.class);
		System.out.println(netFile.getPersons().get(0).getFirstName());
	}

}
