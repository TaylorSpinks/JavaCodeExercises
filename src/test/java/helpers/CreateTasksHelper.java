package helpers;

import org.example.entities.InventoryItem;
import org.example.model.TaskModel;
import org.example.service.enums.InventoryOperationType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateTasksHelper {

    private static final List<String> ITEM_NAMES = List.of(
            "Apple", "Cheddar", "Salmon", "Chicken", "Tofu", "Pasta", "Avocado",
            "Steak", "Rice", "Yogurt", "Mushroom", "Lentils", "Tomato", "Broccoli"
    );

    private static final List<String> ITEM_TYPES = List.of(
            "Fruit", "Vegetable", "Meat", "Dairy", "Grain", "Legume", "Seafood", "Plant-based"
    );

    private static final InventoryOperationType[] OPERATIONS = InventoryOperationType.values();
    private static final Random random = new Random();

    public static ArrayList<TaskModel> generateManyTasks(int count) {
        ArrayList<TaskModel> tasks = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String itemName = ITEM_NAMES.get(random.nextInt(ITEM_NAMES.size()));
            String itemType = ITEM_TYPES.get(random.nextInt(ITEM_TYPES.size()));
            InventoryItem item = new InventoryItem(itemName, itemType);
            int quantity = random.nextInt();

            InventoryOperationType operation = OPERATIONS[random.nextInt(OPERATIONS.length)];

            TaskModel task = new TaskModel();
            task.setInventoryItem(item);
            task.setOperationType(operation);
            task.setQuantity(quantity);

            tasks.add(task);
        }

        return tasks;
    }
}
