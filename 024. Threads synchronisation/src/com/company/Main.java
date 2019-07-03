//Concurrency threads synchronisation

package com.company;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        //First thread synchronisation method
        CounterFirst counterFirst1 = new CounterFirst();
        CounterFirst counterFirst2 = new CounterFirst();

        CountThread t1 = new CountThread(counterFirst1);
        t1.setName("Thread One");

        CountThread t2 = new CountThread(counterFirst2);
        t2.setName("Thread Two");

        CountThread t3 = new CountThread(counterFirst1);
        t3.setName("Thread Three");

        CountThread t4 = new CountThread(counterFirst1);
        t4.setName("Thread Four");

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println();

        t3.start();
        t4.start();

        while (t3.isAlive() || t4.isAlive()) {
        }
        System.out.println();

        //Second thread synchronisation method
        CounterSecond counterSecond1 = new CounterSecond();
        CounterSecond counterSecond2 = new CounterSecond();

        CountThread t5 = new CountThread(counterSecond1);
        t5.setName("Thread Five");

        CountThread t6 = new CountThread(counterSecond2);
        t6.setName("Thread Six");

        CountThread t7 = new CountThread(counterSecond1);
        t7.setName("Thread Seven");

        CountThread t8 = new CountThread(counterSecond1);
        t8.setName("Thread Eight");

        t5.start();
        t6.start();

        while (t5.isAlive() || t6.isAlive()) {
        }
        System.out.println();

        t7.start();
        t8.start();

        while (t7.isAlive() || t8.isAlive()) {
        }
        System.out.println();

        //Third thread synchronisation method
        Message message = new Message();
        Thread write = new Thread(new MessageWriter(message));
        Thread read = new Thread(new MessageReader(message));

        write.start();
        read.start();

        while (write.isAlive() || read.isAlive()) {
        }
        System.out.println();

        //Fourth thread synchronisation method - Producer and Consumer
        List<String> bufferFirst = new ArrayList<String>();

        Thread wordFirstProducer = new Thread(new WordFirstProducer(bufferFirst), "Thread Nine");
        Thread wordFirstConsumer1 = new Thread(new WordFirstConsumer(bufferFirst), "Thread Ten");
        Thread wordFirstConsumer2 = new Thread(new WordFirstConsumer(bufferFirst), "Thread Eleven");
        wordFirstProducer.start();
        wordFirstConsumer1.start();
        wordFirstConsumer2.start();

        while (wordFirstProducer.isAlive() || wordFirstConsumer1.isAlive() || wordFirstConsumer2.isAlive()) {
        }
        System.out.println();

        //Fifth thread synchronisation method - Lock & TryLock
        List<String> bufferSecond = new ArrayList<String>();
        ReentrantLock reentrantLockFirst = new ReentrantLock();

        Thread wordSecondProducer = new Thread(new WordSecondProducer(bufferSecond, reentrantLockFirst), "Thread Twelve");
        Thread wordSecondConsumer1 = new Thread(new WordSecondConsumer(bufferSecond, reentrantLockFirst), "Thread Thirteen");
        Thread wordSecondConsumer2 = new Thread(new WordSecondConsumer(bufferSecond, reentrantLockFirst), "Thread Fourteen");

        wordSecondProducer.start();
        wordSecondConsumer1.start();
        wordSecondConsumer2.start();

        while (wordSecondProducer.isAlive() || wordSecondConsumer1.isAlive() || wordSecondConsumer2.isAlive()) {
        }
        System.out.println();

        //Sixth thread synchronisation method - Fair lock
        ReentrantLock reentrantLockSecond = new ReentrantLock(true);

        Thread t9 = new Thread(new CountThread(new CounterThird(reentrantLockSecond)), "Thread One");
        Thread t10 = new Thread(new CountThread(new CounterThird(reentrantLockSecond)), "Thread Two");
        Thread t11 = new Thread(new CountThread(new CounterThird(reentrantLockSecond)), "Thread Three");
        Thread t12 = new Thread(new CountThread(new CounterThird(reentrantLockSecond)), "Thread Four");

        t9.start();
        t10.start();
        t11.start();
        t12.start();

        while (t9.isAlive() || t10.isAlive() || t11.isAlive() || t12.isAlive()) {
        }
        System.out.println();

        //Thread priority
        CountThread t13 = new CountThread(counterFirst1);
        CountThread t14 = new CountThread(counterFirst1);
        CountThread t15 = new CountThread(counterFirst1);
        CountThread t16 = new CountThread(counterFirst1);
        CountThread t17 = new CountThread(counterFirst1);

        t13.setName("Thread One");
        t14.setName("Thread Two");
        t15.setName("Thread Three");
        t16.setName("Thread Four");
        t17.setName("Thread Five");

        t13.setPriority(9);
        t14.setPriority(7);
        t15.setPriority(5);
        t16.setPriority(3);
        t17.setPriority(1);

        t13.start();
        t14.start();
        t15.start();
        t16.start();
        t17.start();

        while (t13.isAlive() || t14.isAlive() || t15.isAlive() || t16.isAlive() || t17.isAlive()) {
        }
        System.out.println();
    }
}
