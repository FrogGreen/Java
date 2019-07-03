package com.company;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    static Integer age;
    static String name;
    Person person;

    @org.junit.jupiter.api.BeforeAll
    static void beforeAll() {
        age = 45;
        name = "Henry";
        System.out.println("This is printed before all");
    }

    @org.junit.jupiter.api.BeforeEach
    void beforeEach() {
        person = new Person(age, name);
        System.out.println("This is printed before each");
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        assertEquals(age, person.getAge());
    }

    @org.junit.jupiter.api.Test
    void getName() {
//        fail("Not completed!");
        assertTrue(true == false, "Wrong Way");
    }

    @org.junit.jupiter.api.AfterEach
    void afterEach() {
        System.out.println("This is printed after each");
    }

    @org.junit.jupiter.api.AfterAll
    static void afterAll() {
        System.out.println("This is printed after all");
    }
}
