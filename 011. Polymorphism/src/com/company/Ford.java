package com.company;

public class Ford extends Car {

    public Ford(int wheels, int doors, String engine) {
        super(wheels, doors, engine);
    }

    @Override
    public String aboutCar() {
        return "My " + getClass().getSimpleName() + " is great, it can:";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> Accelerate";
    }

    @Override
    public String braking() {
        return getClass().getSimpleName() + " -> Brake";
    }
}
