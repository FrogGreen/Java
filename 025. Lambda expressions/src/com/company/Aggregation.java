package com.company;

public class Aggregation {
    private String name;
    private int weight;

    public Aggregation(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + ": " + weight + "kg";
    }
}
