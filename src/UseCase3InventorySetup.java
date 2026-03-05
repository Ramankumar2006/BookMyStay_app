import java.util.HashMap;
import java.util.Map;



class RoomInventory {


    private Map<String, Integer> roomAvailability;


    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Standard", 10);
        roomAvailability.put("Deluxe", 5);
        roomAvailability.put("Suite", 3);
    }


    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}



public class UseCase3InventorySetup {


    public static void main(String[] args) {


        RoomInventory inventory = new RoomInventory();


        System.out.println("Current Room Availability:");

        for (Map.Entry<String, Integer> entry : inventory.getRoomAvailability().entrySet()) {
            System.out.println(entry.getKey() + " Rooms: " + entry.getValue());
        }

        // Update availability example
        System.out.println("\nUpdating Deluxe room availability...\n");
        inventory.updateAvailability("Deluxe", 4);

        // Display updated inventory
        System.out.println("Updated Room Availability:");

        for (Map.Entry<String, Integer> entry : inventory.getRoomAvailability().entrySet()) {
            System.out.println(entry.getKey() + " Rooms: " + entry.getValue());
        }
    }
}