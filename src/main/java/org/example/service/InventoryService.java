package org.example.service;

import org.example.entities.InventoryItem;

import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {

    private final ConcurrentHashMap<InventoryItem, Integer> inventory;

    public InventoryService(ConcurrentHashMap<InventoryItem, Integer> inventory) {
        this.inventory = inventory;
    }

    public void addStock(InventoryItem inventoryItem, int quantity) {
        this.inventory.put(inventoryItem, quantity);
    }

    public Integer removeStock(InventoryItem inventoryItem, int quantity) {

        int currQuantity = getQuantityByInventoryItem(inventoryItem);

        if (currQuantity - quantity == 0) {
            this.inventory.remove(inventoryItem);
            return 0;
        } else if (currQuantity - quantity > 0) {
            return updateInventoryItemQuantity(inventoryItem, currQuantity - quantity);
        }

        return null;
    }

    public Integer updateInventoryItemQuantity(InventoryItem inventoryItem, int newValue) {
        if (this.inventory.containsKey(inventoryItem)) {
            return this.inventory.put(inventoryItem, newValue);
        }
        return null;
    }

    public int getQuantityByInventoryItem(InventoryItem inventoryItem) {
        return this.inventory.get(inventoryItem);
    }

    public String searchInventory(InventoryItem inventoryItem) {
        if (this.inventory.containsKey(inventoryItem)) {
            return inventoryItem.getItemTypeAndName();
        }
        return "not found";
    }

    public ConcurrentHashMap<InventoryItem, Integer> getWholeInventory() {
        return this.inventory;
    }

}

enum InventoryOperationType {
    ADD, REMOVE, UPDATE
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


