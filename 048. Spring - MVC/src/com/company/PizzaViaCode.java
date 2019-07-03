package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PizzaViaCode extends Pizza {
	private LinkedHashMap<String, String> cityDistrictOptions;
	private LinkedHashMap<String, String> pizzaDoughOptions;
	private List<String> toppingsOptions;

	public PizzaViaCode() {
		cityDistrictOptions = new LinkedHashMap<>();
		cityDistrictOptions.put("Westminster", "Westminster");
		cityDistrictOptions.put("Bromley", "Bromley");
		cityDistrictOptions.put("Newham", "Newham");
		cityDistrictOptions.put("Barking and Dagenham", "Barking and Dagenham");
		cityDistrictOptions.put("Sutton", "Sutton");
		cityDistrictOptions.put("Ealing", "Ealing");

		pizzaDoughOptions = new LinkedHashMap<>();
		pizzaDoughOptions.put("Thin crust", "Thin");
		pizzaDoughOptions.put("Medium crust", "Medium");
		pizzaDoughOptions.put("Thick crust", "Thick");

		toppingsOptions = new ArrayList<String>();
		toppingsOptions.add("Cheese");
		toppingsOptions.add("Ham");
		toppingsOptions.add("Pepperoni");
		toppingsOptions.add("Paprika");
		toppingsOptions.add("Tomato");
		toppingsOptions.add("Pineapple");
		toppingsOptions.add("Corn");
	}

	public LinkedHashMap<String, String> getCityDistrictOptions() {
		return cityDistrictOptions;
	}

	public LinkedHashMap<String, String> getPizzaDoughOptions() {
		return pizzaDoughOptions;
	}

	public List<String> getToppingsOptions() {
		return toppingsOptions;
	}
}