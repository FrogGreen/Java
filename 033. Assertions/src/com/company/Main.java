//Assertions

package com.company;

public class Main {

    public static void main(String[] args) {

        int weight = 15;

        assert weight <= 20 : "Ooops, here is overweight";
        System.out.println("Value of weight is " + weight + ", it's look, that everything is fine.");

        assert weight >= 20 : "Ooops, here is underweight";
        System.out.println("Value of weight is " + weight);
    }
}
