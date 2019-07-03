package com.company;

import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private String color;
    private int age;

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return ("\n||" + this.getName() + ", " + this.getColor() + ", " + this.getAge() + "||");
    }

    @Override
    public int compareTo(Dog dog) {
        return this.getName().compareTo(dog.getName());
    }

    public static Comparator<Dog> Age = new Comparator<Dog>() {

        @Override
        public int compare(Dog dog1, Dog dog2) {
            return (int) (dog1.getAge() - dog2.getAge());
        }
    };

    public static Comparator<Dog> Color = new Comparator<Dog>() {

        @Override
        public int compare(Dog dog1, Dog dog2) {
            return dog1.getColor().compareTo(dog2.getColor());
        }
    };
}
