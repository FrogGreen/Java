package com.company;

public class Person {
    private Integer Age;
    private String Name;

    public Person(Integer age, String name) {
        Age = age;
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public String getName() {
        return Name;
    }
}