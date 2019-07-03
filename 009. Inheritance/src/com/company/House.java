package com.company;

public class House extends Home {
    private int carInGarage;

    public House(int window, int room, int bathroom, int bed, int carInGarage) {
        super(window, room, bathroom, bed);
        this.carInGarage = carInGarage;
    }

    @Override
    public String toString() {
        return super.toString() + " House{" +
            "carInGarage=" + carInGarage +
            '}';
    }

    @Override
    public void myPlaceToLive() {
        super.myPlaceToLive();
        System.out.println("My house is so cool");
    }

    public void checkCarInGarage() {
        System.out.println("Is car in garage?" + " Yes, there are " + carInGarage + " car in garage.");
    }
}
