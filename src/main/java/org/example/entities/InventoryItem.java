package org.example.entities;


import java.util.Objects;

public record InventoryItem(String itemName, String itemType) {

    public String getItemTypeAndName() {
        return this.itemName + " " + this.itemType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }

}
