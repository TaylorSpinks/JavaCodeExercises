import org.example.entities.InventoryItem;
import org.example.service.InventoryService;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryTests {

    @Test
    public void TestAddAndSearchNewItem(){
        InventoryItem inventoryItem = new InventoryItem("pringles", "chips");
        ConcurrentHashMap <InventoryItem, Integer> newInventory = new ConcurrentHashMap<>();
        InventoryService inventoryService = new InventoryService(newInventory);

        int quantity = 3;

        inventoryService.addStock(inventoryItem, quantity);

        int mapSize = inventoryService.getWholeInventory().size();

        String item = inventoryService.searchInventory(inventoryItem);

        assertEquals(1,mapSize);
        assertEquals("pringles chips", item);
    }

    @Test
    public void TestRemoveEntireItemWhenNoQuantityLeft(){
        InventoryItem inventoryItem = new InventoryItem("pringles", "chips");
        ConcurrentHashMap <InventoryItem, Integer> newInventory = new ConcurrentHashMap<>();
        InventoryService inventoryService = new InventoryService(newInventory);

        int quantity = 3;

        inventoryService.addStock(inventoryItem, quantity);

        int quantityToRemove = 3;

         inventoryService.removeStock(inventoryItem, quantityToRemove);

        int mapSize = inventoryService.getWholeInventory().size();

        String item = inventoryService.searchInventory(inventoryItem);

        assertEquals(0,mapSize);
        assertEquals("not found", item);
    }

}
