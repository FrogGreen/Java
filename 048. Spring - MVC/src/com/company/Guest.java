package com.company;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.company.validation.ValidationCode;

public class Guest {
	private String firstName;

	@NotNull(message = "This field is required")
	@Size(min = 1, message = "This field is required")
	private String lastName;

	@NotNull(message = "This field is required")
	@Min(value = 0, message = "Are you shure you are younger then 0?")
	@Max(value = 150, message = "Are you shure you are older then 150?")
	private Integer age;

	@NotNull(message = "This field is required")
	@Pattern(regexp = "^[a-zA-Z0-9]{5,5}", message = "This field require 5 chars/digit")
	private String postalCode;

	@NotNull(message = "This field is required")
	@ValidationCode()
	private String validationCode;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getValidationCode() {
		return validationCode;
	}

	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}
}