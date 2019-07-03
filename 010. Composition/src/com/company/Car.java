package com.company;

public class Car extends Vehicle {
    private Gearbox gearbox;
    public Engine engine;
    private int door;

    public Car(int wheel, int weight, int door, Gearbox gearbox, Engine engine) {
        super(wheel, weight);
        this.gearbox = gearbox;
        this.engine = engine;
        this.door = door;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getDoor() {
        return door;
    }

    //Car start
    public void start() {
        engine.start();
        engine.setPercentOfMaxSpeed(5);
        engine.isOn();
        gearbox.setRpm(700);
        gearbox.setCurrentGear(0);
    }

    //Car stop
    public void stop() {
        engine.stop();
        engine.setPercentOfMaxSpeed(0);
        engine.isOn();
        gearbox.setRpm(0);
        gearbox.setCurrentGear(0);
    }

    //Change car speed
    public void changeSpeed(int accelerate) {
        if (engine.getPercentOfMaxSpeed() + accelerate > 100 || engine.getPercentOfMaxSpeed() + accelerate < 0) {
            System.out.println("Speed change impossible");
        } else {
            engine.setPercentOfMaxSpeed(engine.getPercentOfMaxSpeed() + accelerate);
            gearbox.setCurrentGear(gearbox.getMaxGear() * engine.getPercentOfMaxSpeed() / 100);
            //If Current gear is equal to 0, Car stop
            if ((gearbox.getCurrentGear() * gearbox.getTransmission()) == 0) {
                stop();
            } else {
                gearbox.setRpm(engine.getPercentOfMaxSpeed() * 1500 / (gearbox.getCurrentGear() * gearbox.getTransmission()));
            }
        }
    }

    //Current Car parameter
    public void carParameter() {
        engine.isOn();
        System.out.println("RPM: " + gearbox.getRpm());
        System.out.println("Current Gear: " + gearbox.getCurrentGear());
        System.out.println("Current Speed: " + engine.getPercentOfMaxSpeed() + "%.");
    }
}
