package com.company.springRestJsonJackson;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Sample sample = objectMapper.readValue(new File("data/sampleFile.json"), Sample.class);
			System.out.println("Sample first name: " + sample.getFirstName());
			System.out.println("Sample last name: " + sample.getLastName());
			System.out.println("Sample ID: " + sample.getId());
			System.out.println("Sample typo: " + sample.isTypo());
			System.out.println("Sample webAddress: " + sample.getWebAddress());
			System.out.print("Sample languages: ");
			for (String string : sample.getLanguages()) {
				System.out.print(string + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}