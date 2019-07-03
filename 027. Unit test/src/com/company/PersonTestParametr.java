package com.company;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PersonTestParametr {

    Integer age = 45;

    @ParameterizedTest
    @ValueSource
        (strings = {"racecar", "radar", "able was I ere I saw elba"})
    public void personSecondTest(String string) {
        Person person = new Person(age, string);
    }

    @ParameterizedTest
    @ValueSource
        (strings = {"racecar", "radar", "able was I ere I saw elba"})
    public void personFirstTest(String string) {
        Person person = new Person(age, string);
    }
}
