package com.company;

public class Car {
    private String brand;
    private String model;
    private String numberVIN;
    private int numberOfDoor;

    public Car() {
    }

    public Car(String brand, String model, String numberVIN, int numberOfDoor) {
        this.brand = brand;
        this.model = model;
        this.numberVIN = numberVIN;
        this.numberOfDoor = numberOfDoor;
    }

    @Override
    public String toString() {
        return "Car: {" +
            "brand= " + brand +
            ", model= " + model +
            ", numberVIN= " + numberVIN +
            ", numberOfDoor= " + numberOfDoor +
            '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberVIN() {
        return numberVIN;
    }

    public void setNumberVIN(String numberVIN) {
        this.numberVIN = numberVIN;
    }

    public int getNumberOfDoor() {
        return numberOfDoor;
    }

    public void setNumberOfDoor(int numberOfDoor) {
        this.numberOfDoor = numberOfDoor;
    }
}
