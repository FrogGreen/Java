package com.company;

public class CountThread extends Thread {
    private CounterFirst counterFirst;
    private CounterSecond counterSecond;
    private CounterThird counterThird;

    public CountThread(CounterFirst counterFirst) {
        this.counterFirst = counterFirst;
    }

    public CountThread(CounterSecond counterSecond) {
        this.counterSecond = counterSecond;
    }

    public CountThread(CounterThird counterThird) {
        this.counterThird = counterThird;
    }

    @Override
    public void run() {
        if (counterFirst != null) {
            counterFirst.count();
        } else if (counterSecond != null) {
            counterSecond.count();
        } else if (counterThird != null) {
            counterThird.count();
        }
    }
}
