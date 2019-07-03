package com.company;

public class Pizza {
	private String streetName;
	private String cityDistrict;
	private Integer houseNumber;
	private String pizzaDough;
	private String[] toppings;

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityDistrict() {
		return cityDistrict;
	}

	public void setCityDistrict(String cityDistrict) {
		this.cityDistrict = cityDistrict;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPizzaDough() {
		return pizzaDough;
	}

	public void setPizzaDough(String pizzaDough) {
		this.pizzaDough = pizzaDough;
	}

	public String[] getToppings() {
		return toppings;
	}

	public void setToppings(String[] toppings) {
		this.toppings = toppings;
	}
}