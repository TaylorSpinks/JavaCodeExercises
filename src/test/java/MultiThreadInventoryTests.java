import helpers.CreateTasksHelper;
import org.example.entities.InventoryItem;
import org.example.model.TaskModel;
import org.example.service.ThreadService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadInventoryTests {
    @Test
    void test20Threads() throws InterruptedException {
        ArrayList<TaskModel> ListOfTasks = CreateTasksHelper.generateManyTasks(20);

        ThreadService threadService = new ThreadService();

        ConcurrentHashMap<InventoryItem, AtomicInteger> inventoryItems = threadService.runTasks(ListOfTasks);

        for (Map.Entry<InventoryItem, AtomicInteger> item : inventoryItems.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

}
