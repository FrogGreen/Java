package com.company;

import static com.company.ConsoleColors.*;

public class SequentThread extends Thread {
    private String number;
    private String color;

    public SequentThread(String number, String color) {
        this.number = number;
        this.color = color;
    }

    @Override
    public void run() {
        System.out.println(color + "This is " + number + " message!" + RESET);
    }
}
