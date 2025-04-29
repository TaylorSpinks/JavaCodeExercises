package org.example.service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadService {
    public int manyThreadsCallUnSafeCounter(int numberOfThreads) throws InterruptedException {
        ArrayList<Thread> listOfThreads = new ArrayList<>();
        UnsafeCounter unsafeCounter = new UnsafeCounter();
        for(int i = 0; i < numberOfThreads; i++){
            listOfThreads.add(new Thread(unsafeCounter));
        }

        for(Thread thread : listOfThreads){{
            thread.start();
            thread.join();
        }}

        return unsafeCounter.getCount();
    }

    public AtomicInteger oneThreadCallsSafeCounterManyTimes(int times) throws InterruptedException {
        SafeCounter safeCounter = new SafeCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                safeCounter.increment();
            }
        });

        thread1.start();
        thread1.join();

        return safeCounter.getCount();
    }
}
