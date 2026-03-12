import java.util.*;

public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        // Step 1: Create a Map to link Reservation ID to a List of Service Costs
        Map<String, List<Double>> addOnServices = new HashMap<>();

        // Step 2: Define a Reservation ID
        String reservationId = "Single-1";

        // Step 3: Create a list of service costs (e.g., Breakfast: 500, WiFi: 1000)
        List<Double> costs = new ArrayList<>();
        costs.add(500.0);
        costs.add(1000.0);

        // Step 4: Map the services to the Reservation ID
        addOnServices.put(reservationId, costs);

        // Step 5: Calculate total cost
        double totalCost = 0;
        for (double cost : addOnServices.get(reservationId)) {
            totalCost += cost;
        }

        // Output matching the requirement
        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}
