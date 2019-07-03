package com.company;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.ConsoleColors.*;

public class WordSecondProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    public WordSecondProducer(List<String> buffer, ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.reentrantLock = reentrantLock;
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
        String messages[] = {
            "Greenfrog", "is", "very", "good", "frog"
        };

        for (String message : messages) {
            try {
                System.out.println(color + "Adding..." + message + RESET);
                try {
                    reentrantLock.lock();
                    buffer.add(message);
                } finally {
                    reentrantLock.unlock();
                }
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.out.println(color + "Producer was interrupted" + RESET);
            }
        }
        System.out.println(color + "Exiting..." + RESET);
        reentrantLock.lock();
        buffer.add("EOF");
        reentrantLock.unlock();
    }
}
