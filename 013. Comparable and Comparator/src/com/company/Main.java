//Comparable and Comparator

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.Dog.Age;
import static com.company.Dog.Color;

public class Main {

    public static void main(String[] args) {

        //Array
        System.out.print("Array\n");
        Dog[] dog = new Dog[5];
        dog[0] = new Dog("Klavi", "Brown", 4);
        dog[1] = new Dog("Ornim", "Black", 5);
        dog[2] = new Dog("Alvin", "Brown", 3);
        dog[3] = new Dog("Lessie", "White", 2);
        dog[4] = new Dog("Bambi", "Black", 3);

        //Default array order
        System.out.println("Default order of Dog array:\n" + Arrays.toString(dog));

        //Name sorted array order
        Arrays.sort(dog);
        System.out.println("\nName order of Dog array:\n" + Arrays.toString(dog));

        //Age sorted array order
        //If same age sort by name
        Arrays.sort(dog, Age);
        System.out.println("\nAge order of Dog array:\n" + Arrays.toString(dog));

        //Color sorted array order
        Arrays.sort(dog, Dog.Color);
        System.out.println("\nColor order of Dog array:\n" + Arrays.toString(dog));

        //Age sorted array order
        //If same age sort by color
        Arrays.sort(dog, Age);
        System.out.println("\nAge order of Dog array:\n" + Arrays.toString(dog));


        //List
        System.out.print("\n\n\nList");
        List<Dog> dogdog = new ArrayList<>();
        dogdog.add(new Dog("Klavi", "Brown", 4));
        dogdog.add(new Dog("Ornim", "Black", 5));
        dogdog.add(new Dog("Alvin", "Brown", 3));
        dogdog.add(new Dog("Lessie", "White", 2));
        dogdog.add(new Dog("Bambi", "Black", 3));

        //Default list order
        System.out.println("\nDefault order of Dog list:\n" + dogdog);

        //Name sorted list order
        dogdog.sort(Dog::compareTo);
        System.out.println("\nName order of Dog list:\n" + dogdog);

        //Age sorted list order
        //If same age sort by name
        dogdog.sort(Age);
        System.out.println("\nAge order of Dog list:\n" + dogdog);

        //Color sorted list order
        dogdog.sort(Color);
        System.out.println("\nColor order of Dog list:\n" + dogdog);

        //Age sorted list order
        //If same age sort by color
        dogdog.sort(Age);
        System.out.println("\nAge order of Dog list:\n" + dogdog);
    }
}
