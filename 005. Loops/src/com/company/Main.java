//Loops

package com.company;

public class Main {

    public static void main(String[] args) {

        //For loop
        System.out.println("For loop:");
        int numberOfSign = 50;
        int number = 0;
        boolean alarmBeep = true;

        for (int i = 1; i <= numberOfSign; i *= 2) {
            System.out.println("Warning number #" + i);
        }
        System.out.println();


        //While loop with break
        System.out.println("While loop:");
        while (alarmBeep == true) {
            number += 5;
            if (number >= numberOfSign) {
                //alarmBeep = false;
                break;
            }
            System.out.println("Alarm number #" + number);
        }
        System.out.println();


        //Do-while loop
        System.out.println("Do-while loop:");
        number = 0;
        alarmBeep = false;
        do {
            number += 5;
            if (number >= numberOfSign) {
                alarmBeep = false;
                break;
            }
            System.out.println("Notice number #" + number);
        } while (alarmBeep == true);
        {
            System.out.println("Do while loop is always minimum 1 time executed");
        }
        System.out.println();


        //Continue keyword
        System.out.println("Continue keyword:");
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (i == j) {
                    continue;
                }
                System.out.println("Caution, number of error #" + i + j);
            }
        }
        System.out.println();


        //Break keyword
        System.out.println("Break keyword:");
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (i == j) {
                    break;
                }
                System.out.println("Caution, number of error #" + i + j);
            }
        }
        System.out.println();


        //Break keyword to named action
        System.out.println("Break keyword to named action:");
        action:
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (i == j) {
                    break action;
                }
                System.out.println("Caution, number of error #" + i + j);
            }
        }
        System.out.println();
    }
}
