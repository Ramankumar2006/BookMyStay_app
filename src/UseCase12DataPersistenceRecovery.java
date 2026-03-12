import java.util.*;

public class UseCase12DataPersistenceRecovery {
    public static void main(String[] args) {
        // Step 1: Simulated "Database" or File State
        boolean fileExists = false;

        System.out.println("System Recovery");

        // Step 2: Handle Persistence Logic
        if (!fileExists) {
            System.out.println("No valid inventory data found. Starting fresh.\n");
        }

        // Step 3: Set Current Inventory State
        Map<String, Integer> inventory = new LinkedHashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        // Step 4: Display the Restored Inventory
        System.out.println("Current Inventory:");
        inventory.forEach((type, count) -> System.out.println(type + ": " + count));

        // Step 5: Simulate Saving
        System.out.println("\nInventory saved successfully.");
    }
}
