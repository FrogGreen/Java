package com.company;

import static com.company.ConsoleColors.*;

public class AlternativeRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(CYAN + "This is fourth message!" + RESET);
    }
}