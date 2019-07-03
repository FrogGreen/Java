package com.company;

import java.util.concurrent.locks.ReentrantLock;

import static com.company.ConsoleColors.*;

public class CounterThird {

    private int i;
    private int j;
    private ReentrantLock reentrantLock;

    public CounterThird(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    public void count() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread One":
                color = RED;
                break;
            case "Thread Two":
                color = GREEN;
                break;
            case "Thread Three":
                color = YELLOW;
                break;
            case "Thread Four":
                color = BLUE;
                break;
            case "Thread Five":
                color = RED_UNDERLINED;
                break;
            case "Thread Six":
                color = GREEN_UNDERLINED;
                break;
            case "Thread Seven":
                color = YELLOW_UNDERLINED;
                break;
            case "Thread Eight":
                color = BLUE_UNDERLINED;
                break;
            case "Thread Nine":
                color = RED_BOLD;
                break;
            case "Thread Ten":
                color = GREEN_BOLD;
                break;
            case "Thread Eleven":
                color = YELLOW_BOLD;
                break;
            case "Thread Twelve":
                color = BLUE_BOLD;
                break;
            case "Thread Thirteen":
                color = PURPLE_BOLD;
                break;
            case "Thread Fourteen":
                color = CYAN_BOLD;
                break;
            default:
                color = PURPLE;
                break;
        }

        System.out.println(color + "Welcome in " + Thread.currentThread().getName() + RESET);

        for (j = 1; j < 4; j++) {
            reentrantLock.lock();
            try {
                System.out.println(color + Thread.currentThread().getName() + " step is: " + j + RESET);
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
