package com.company;

public class Opel extends Car {

    public Opel(int wheels, int doors, String engine) {
        super(wheels, doors, engine);
    }

    @Override
    public String aboutCar() {
        return super.aboutCar() + "\nMy Opel is great, it can:";
    }

    @Override
    public String accelerate() {
        return super.accelerate() + "\nOpel -> Accelerate";
    }

    @Override
    public String braking() {
        return super.braking() + "\nOpel -> Brake";
    }
}
