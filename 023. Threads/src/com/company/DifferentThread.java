package com.company;

import static com.company.ConsoleColors.*;

public class DifferentThread extends Thread {

    @Override
    public void run() {
        System.out.println(PURPLE + "This is sixth message!" + RESET);

        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            System.out.println(PURPLE + "Something went wrong, sleep not executed!" + RESET);
            return;
        }

        System.out.println(PURPLE + "This is seventh message!" + RESET);
    }
}