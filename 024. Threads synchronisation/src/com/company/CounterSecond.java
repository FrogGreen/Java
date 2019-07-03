package com.company;

import static com.company.ConsoleColors.*;

public class CounterSecond {

    private int i;
    private int j;

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

        for (i = 3; i > 0; i--) {
            System.out.println(color + "Wait " + i + " for start " + Thread.currentThread().getName() + RESET);
        }

        synchronized (this) {
            for (j = 1; j < 4; j++) {
                System.out.println(color + Thread.currentThread().getName() + " step is: " + j + RESET);
            }
        }
    }
}
