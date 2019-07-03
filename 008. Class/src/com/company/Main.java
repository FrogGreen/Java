//Class

package com.company;

public class Main {

    public static void main(String[] args) {

        //Creating new object Mazda RX
        Car mazdaRX = new Car();
        mazdaRX.setBrand("Mazda");
        mazdaRX.setModel("RX");
        mazdaRX.setNumberVIN("WXYZ6324");
        mazdaRX.setNumberOfDoor(4);

        //Creating new object Ford Focus
        Car fordFocus = new Car("Ford", "Focus", "WX0Y6234", 4);

        //Printing information about these object
        System.out.println(mazdaRX);
        System.out.println(fordFocus);
    }
}
