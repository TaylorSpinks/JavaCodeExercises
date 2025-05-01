package org.example.model;

import org.example.entities.InventoryItem;
import org.example.service.enums.InventoryOperationType;

public class TaskModel {
    private InventoryOperationType operationType;
    private InventoryItem inventoryItems;
    private int quantity;

    public InventoryItem getInventoryItems() {
        return inventoryItems;
    }

    public InventoryOperationType getOperationType() {
        return operationType;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setInventoryItem(InventoryItem inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    public void setOperationType(InventoryOperationType operationType) {
        this.operationType = operationType;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
