package com.company;

public class Engine {
    private int percentOfMaxSpeed;
    private int horsePower;
    private int cylinders;
    private int valve;
    private boolean isOn;

    public Engine(int horsePower, int cylinders, int valve) {
        this(0, horsePower, cylinders, valve, false);
    }

    public Engine(int percentOfMaxSpeed, int horsePower, int cylinders, int valve, boolean isOn) {
        this.percentOfMaxSpeed = percentOfMaxSpeed;
        this.horsePower = horsePower;
        this.cylinders = cylinders;
        this.valve = valve;
        this.isOn = isOn;
    }

    public int getPercentOfMaxSpeed() {
        return percentOfMaxSpeed;
    }

    public void setPercentOfMaxSpeed(int percentOfMaxSpeed) {
        this.percentOfMaxSpeed = percentOfMaxSpeed;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getValve() {
        return valve;
    }

    //Is engine on or stop
    public void isOn() {
        String statement = isOn ? "Engine is on" : "Engine stop";
        System.out.println(statement);
    }

    public void start() {
        this.isOn = true;

    }

    public void stop() {
        this.isOn = false;
    }
}
