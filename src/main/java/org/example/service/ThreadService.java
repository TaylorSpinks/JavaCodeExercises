package org.example.service;

import org.example.entities.InventoryItem;
import org.example.model.TaskModel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
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

    public ConcurrentHashMap<InventoryItem, AtomicInteger> runTasks(ArrayList<TaskModel> tasksToRun) throws InterruptedException {
        ConcurrentHashMap<InventoryItem, AtomicInteger> inventoryItems = new ConcurrentHashMap<>();
        InventoryService inventoryService = new InventoryService(inventoryItems);
        ArrayList<Thread> listOfThreads = new ArrayList<>();
        for(TaskModel task : tasksToRun){
            InventoryTask inventoryTask = new InventoryTask(inventoryService, task.getOperationType(), task.getInventoryItems(), task.getQuantity());
            listOfThreads.add(new Thread(inventoryTask));
        }

        for (Thread thread : listOfThreads){
            thread.start();
        }

        for (Thread thread : listOfThreads){
            thread.join();
        }

        return inventoryItems;
    }


}
