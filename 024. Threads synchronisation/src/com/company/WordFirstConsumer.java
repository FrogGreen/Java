package com.company;

import java.util.List;

import static com.company.ConsoleColors.*;

public class WordFirstConsumer implements Runnable {
    private List<String> buffer;
    private String color;

    public WordFirstConsumer(List<String> buffer) {
        this.buffer = buffer;
    }

    public void setColor() {
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
    }

    @Override
    public void run() {

        this.setColor();

        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals("EOF")) {
                    System.out.println(color + "Exiting..." + RESET);
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0) + RESET);
                }
            }
        }
    }
}
