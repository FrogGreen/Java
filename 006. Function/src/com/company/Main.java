//Function

package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("0 Degree Celsius is: " + String.format("%.2f", celsiusToKelvin(0)) + " Kelvins,");
        System.out.println("but 0 Kelvins is: " + String.format("%.2f", kelvinToCelsius(0)) + " Degree Celsius.");
    }

    //Calculate from celsius to kelvin
    public static double celsiusToKelvin(double celsius) {
        return (celsius + 273.15);
    }

    //Calculate from kelvin to celsius
    public static double kelvinToCelsius(double kelvin) {
        return (kelvin - 273.15);
    }
}
