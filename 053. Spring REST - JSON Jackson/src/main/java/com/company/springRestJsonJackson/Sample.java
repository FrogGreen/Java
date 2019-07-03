package com.company.springRestJsonJackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sample {

	private int id;
	private String firstName;
	private String lastName;
	private boolean typo;
	private WebAddress webAddress;
	private String[] languages;

	public Sample() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isTypo() {
		return typo;
	}

	public void setTypo(boolean typo) {
		this.typo = typo;
	}

	public WebAddress getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(WebAddress webAddress) {
		this.webAddress = webAddress;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
}