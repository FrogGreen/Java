//Concurrency threads

package com.company;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.company.ConsoleColors.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(YELLOW + "This is first message!" + RESET + "\n");

        //First method to run new thread
        Thread alternativeThread = new AlternativeThread();
        alternativeThread.setName("Alternative Thread");

        alternativeThread.run();
        alternativeThread.start();

        //Second method to run new thread - Anonymous class implementation
        new Thread() {
            public void run() {
                System.out.println(BLUE_BACKGROUND + "This is third message!" + RESET + "\n");
            }
        }.start();

        //Wait to finish alternativeThread
        while (alternativeThread.isAlive()) {
        }
        System.out.println(BLUE + "alternativeThread is dead" + RESET);

        //Third method to run new thread
        Thread alternativeRunnable = new Thread(new AlternativeRunnable());

        alternativeRunnable.start();

        //Fourth method to run new thread - Anonymous class implementation
        new Thread(new AlternativeRunnable() {
            @Override
            public void run() {
                System.out.println(CYAN_BACKGROUND + "This is fifth message!" + RESET + "\n");
            }
        }).start();

        //Wait to finish alternativeRunnable
        while (alternativeRunnable.isAlive()) {
        }
        System.out.println(CYAN + "alternativeRunnable is dead" + RESET);

        //Sleep thread
        Thread differentThread = new DifferentThread();

        differentThread.start();
        differentThread.interrupt();

        //Wait to finish differentThread
        while (differentThread.isAlive()) {
        }
        System.out.println(PURPLE + "differentThread is dead" + RESET + "\n");

        //Join to another thread
        System.out.println("Two thread run:");
        Thread otherThread = new OtherThread();

        otherThread.start();
        new Thread() {
            public void run() {
                System.out.println(RED_BACKGROUND + "Let's start another thread!" + RESET);
                try {
                    otherThread.join();
                    System.out.println(RED_BACKGROUND + "Let's start another thread again!" + RESET);
                } catch (InterruptedException e) {
                    System.out.println(RED_BACKGROUND + "Something went wrong!" + RESET);
                }
            }
        }.start();

        //Wait to finish otherThread
        while (otherThread.isAlive()) {
        }
        System.out.println(RED + "otherThread is dead" + RESET + "\n");

        //Thread pools
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Thread sequentThread1 = new SequentThread("tenth", RED_BOLD_BRIGHT);
        Thread sequentThread2 = new SequentThread("eleven", GREEN_BOLD_BRIGHT);
        Thread sequentThread3 = new SequentThread("twelve", BLUE_BOLD_BRIGHT);

        executorService.execute(sequentThread1);
        executorService.execute(sequentThread2);
        executorService.execute(sequentThread3);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(CYAN_BOLD_BRIGHT + "This is thirteen message!" + RESET);
                return null;
            }
        });

        executorService.shutdown();

        //Wait to finish executorService
        while (!executorService.isTerminated()) {
        }
        System.out.println(PURPLE_BOLD_BRIGHT + "executorService is dead" + RESET + "\n");
    }
}
