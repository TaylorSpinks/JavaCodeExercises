package org.example.service;

import org.example.entities.InventoryItem;
import org.example.service.enums.InventoryOperationType;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class InventoryService {

    private final ConcurrentHashMap<InventoryItem, AtomicInteger> inventory;

    public InventoryService(ConcurrentHashMap<InventoryItem, AtomicInteger> inventory) {
        this.inventory = inventory;
    }

    public void addStock(InventoryItem inventoryItem, int quantity) {
        inventory.computeIfAbsent(inventoryItem, k -> new AtomicInteger(0)).addAndGet(quantity);
    }

    public Integer removeStock(InventoryItem inventoryItem, int quantity) {
        int currQuantity = getQuantityByInventoryItem(inventoryItem).get();

        if (currQuantity-quantity == 0) {
            this.inventory.remove(inventoryItem);
            return 0;
        } else if (currQuantity-quantity > 0) {
            return updateInventoryItemQuantity(inventoryItem, currQuantity);
        }

        return null;
    }

    public Integer updateInventoryItemQuantity(InventoryItem inventoryItem, int newValue) {
        AtomicInteger current = this.inventory.computeIfAbsent(inventoryItem, k -> new AtomicInteger(0));
        return current.getAndAdd(newValue);
    }

    public AtomicInteger getQuantityByInventoryItem(InventoryItem inventoryItem) {
        return this.inventory.getOrDefault(inventoryItem,new AtomicInteger(0));
    }

    public String searchInventory(InventoryItem inventoryItem) {
        if (this.inventory.containsKey(inventoryItem)) {
            return inventoryItem.getItemTypeAndName();
        }
        return "not found";
    }

    public ConcurrentHashMap<InventoryItem, AtomicInteger> getWholeInventory() {
        return this.inventory;
    }

}


class InventoryTask implements Runnable {
    private final InventoryService inventoryService;
    private final InventoryOperationType type;
    private final InventoryItem inventoryItem;
    private final int quantity;

    public InventoryTask(InventoryService inventoryService, InventoryOperationType type, InventoryItem inventoryItem, int quantity) {
        this.inventoryService = inventoryService;
        this.type = type;
        this.inventoryItem = inventoryItem;
        this.quantity = quantity;
    }

    public void run(){
        switch (type){
            case ADD -> inventoryService.addStock(inventoryItem, quantity);
            case REMOVE -> inventoryService.removeStock(inventoryItem, quantity);
            case UPDATE -> inventoryService.updateInventoryItemQuantity(inventoryItem, quantity);
        }
    }
}


