//Operation on variable

package com.company;

public class Main {

    public static void main(String[] args) {

        String name = "FrogGreen";

        System.out.println("FrogGreen has got: " + name.length() + " characters");                  //There are 9 letters in this name
        System.out.println(name.toUpperCase());                                                      //Make all characters Upper
        System.out.println(name.toLowerCase());                                                      //Make all characters Lower
        System.out.println(name + " is starting programming in java\n");

        System.out.println("4+3 is: " + (4 + 3));                 //Addition - 7
        System.out.println("5-2 is: " + (5 - 2));                 //Subtraction - 3
        System.out.println("6*8 is: " + 6 * 8);                   //Multiplication - 48
        System.out.println("42|8 is: " + 42 % 8);                 //Modulo - 2
        System.out.println("43/2 is: " + 43 / 2);                 //Division - 21
        System.out.println("but 43/2.0 is: " + 43 / 2.0 + "\n");    //Division - 21.5

        int x = 5;
        int y = 2;
        double z = x / y;

        System.out.println("Wrong value: " + z);
        z = (double) x / y;
        System.out.println("Right value: " + z);
    }
}
