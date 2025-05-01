import helpers.CreateTasksHelper;
import org.example.entities.InventoryItem;
import org.example.model.TaskModel;
import org.example.service.ThreadService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MultiThreadInventoryTests {
    @Test
    void test20Threads() throws InterruptedException {
        ArrayList<TaskModel> ListOfTasks = CreateTasksHelper.generateManyTasks(20);
        ConcurrentHashMap<InventoryItem, Integer> inventoryItems = new ConcurrentHashMap<>();

        ThreadService threadService = new ThreadService();

        inventoryItems = threadService.runTasks(ListOfTasks);

        for (Map.Entry<InventoryItem, Integer> item : inventoryItems.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

}
