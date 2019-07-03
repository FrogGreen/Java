package com.company;

public class Car {
    private int wheels;
    private int doors;
    private String engine;

    //Overloading
    public Car() {
        this(4, 4, "Default engine");
    }

    //Overloading
    public Car(int wheels, int doors, String engine) {
        this.wheels = wheels;
        this.doors = doors;
        this.engine = engine;
    }

    public String aboutCar() {
        return "My car is great, it can:";
    }

    public String accelerate() {
        return "Car -> Accelerate";
    }

    public String braking() {
        return "Car -> Brake";
    }
}
