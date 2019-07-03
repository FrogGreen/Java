//Inheritance

package com.company;

public class Main {

    public static void main(String[] args) {

        //Creating new Home
        Home myFirstHome = new Home(10, 2, 1, 2);

        //Creating new House
        House myFirstHouse = new House(10, 3, 1, 2, 3);
        ;

        //Creating new Flat
        Flat myFirstFlat = new Flat(3, 2, 1, 1, 1);

        //Implicit casting Home
        Home mySecondHome = new House(10, 3, 1, 2, 2);
        Home myThirdHome = new Flat(3, 2, 1, 1, 1);

        //Override method toString
        System.out.println(myFirstHome);
        System.out.println(myFirstHouse);
        System.out.println(myFirstFlat);
        System.out.println(mySecondHome);
        System.out.println(myThirdHome);

        //Override method myPlaceToLive
        myFirstHome.myPlaceToLive();
        mySecondHome.myPlaceToLive();

        //Method checkCarInGarage
        myFirstHouse.checkCarInGarage();
        ((House) mySecondHome).checkCarInGarage();
    }
}
