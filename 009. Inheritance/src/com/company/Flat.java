package com.company;

public class Flat extends Home {
    private int carPark;

    public Flat(int window, int room, int bathroom, int bed, int carPark) {
        super(window, room, bathroom, bed);
        this.carPark = carPark;
    }

    @Override
    public String toString() {
        return "Flat{" +
            "carPark=" + carPark +
            '}';
    }
}
