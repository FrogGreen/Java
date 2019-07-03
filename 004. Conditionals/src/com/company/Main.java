//Conditionals

package com.company;

public class Main {

    public static void main(String[] args) {

        //If statement
        System.out.println("If statement:");
        boolean isRaining = true;
        boolean skyIsCloudy = true;
        boolean sunShines = true;
        int temperature = 18;

        if (isRaining) {
            System.out.println("You will need an umbrella");
        } else if (skyIsCloudy) {
            System.out.println("It is possible to rain.");
        } else {
            System.out.println("Have a nice day");
        }
        if (isRaining && sunShines) {
            System.out.println("Search for the rainbow");
        }
        System.out.println();


        //Ternary operator
        System.out.println("Ternary operator:");
        String ternaryOperator;
        ternaryOperator = (temperature > 19) ? "It's hot outside" : "It's cold outside";
        System.out.println(ternaryOperator + "\n");


        //Switch statement
        System.out.println("Switch statement:");
        String accessCode = "000";
        switch (accessCode) {
            case "001":
                System.out.println("Hello George!");
                break;
            case "002":
                System.out.println("Hello Stephen!");
                break;
            case "003":
                System.out.println("Hello Lucy!");
                break;
            default:
                System.out.println("Unauthorized access");
        }
    }
}
