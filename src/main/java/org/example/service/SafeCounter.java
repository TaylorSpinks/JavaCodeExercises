package org.example.service;

import java.util.concurrent.atomic.AtomicInteger;

class SafeCounter {
    private final AtomicInteger threadCounter = new AtomicInteger(0);

    public void increment(){
        threadCounter.getAndIncrement();
    }

    public AtomicInteger getCount(){
        return threadCounter;
    }
}

class SafeCounterSynchronisedExample implements Runnable {
    private int threadCounter;

    private synchronized void increment(){
        this.threadCounter = threadCounter +1;
    }

    public int getCount(){
        return threadCounter;
    }

    @Override
    public void run() {
        increment();
    }
}

class UnsafeCounter implements Runnable {
    private int threadCounter;

    private void increment(){
        this.threadCounter = threadCounter +1;
    }

    public int getCount(){
        return threadCounter;
    }

    @Override
    public void run() {
        increment();
    }
}