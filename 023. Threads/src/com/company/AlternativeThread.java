package com.company;

import static com.company.ConsoleColors.*;

public class AlternativeThread extends Thread {

    @Override
    public void run() {
        System.out.println(BLUE + "Welcome in: " + currentThread().getName());
        System.out.println("This is second message!" + RESET);
    }
}