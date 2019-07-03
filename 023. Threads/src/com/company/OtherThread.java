package com.company;

import static com.company.ConsoleColors.*;

public class OtherThread extends Thread {

    @Override
    public void run() {
        System.out.println(RED + "This is eighth message!" + RESET);

        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            System.out.println(RED + "Something went wrong, sleep not executed!" + RESET);
            return;
        }

        System.out.println(RED + "This is ninth message!" + RESET);
    }
}