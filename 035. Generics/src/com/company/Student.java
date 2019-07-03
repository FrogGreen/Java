package com.company;

public abstract class Student {

    private String name;
    private int age;
    private double gradeAverage;

    public Student(String name, int age, double gradeAverage) {
        this.name = name;
        this.age = age;
        this.gradeAverage = gradeAverage;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGradeAverage() {
        return gradeAverage;
    }
}