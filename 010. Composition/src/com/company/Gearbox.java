package com.company;

public class Gearbox {
    private int rpm;
    private int transmission;
    private int maxGear;
    private int currentGear;

    public Gearbox(int transmission, int maxGear) {
        this(0, transmission, maxGear, 0);
    }

    public Gearbox(int rpm, int transmission, int maxGear, int currentGear) {
        this.rpm = rpm;
        this.transmission = transmission;
        this.maxGear = maxGear;
        this.currentGear = currentGear;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public int getTransmission() {
        return transmission;
    }

    public int getMaxGear() {
        return maxGear;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }
}
