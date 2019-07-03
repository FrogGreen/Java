package com.company;

public class Honda extends Car {

    public Honda(int wheels, int doors, String engine) {
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
