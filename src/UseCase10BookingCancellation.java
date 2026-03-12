import java.util.Stack;

public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        // Step 1: Initialize Inventory and Rollback Stack
        int singleRoomAvailability = 5;
        Stack<String> rollbackHistory = new Stack<>();

        // Step 2: Define a Reservation to cancel
        String reservationId = "Single-1";

        // Step 3: Perform Cancellation Logic
        // Increment inventory (Restore)
        singleRoomAvailability++;
        // Push to Stack (Rollback History)
        rollbackHistory.push("Released Reservation ID: " + reservationId);

        // Step 4: Display Output as per requirements
        System.out.println("Booking Cancellation");
        System.out.println("Booking cancelled successfully. Inventory restored for room type: Single\n");

        System.out.println("Rollback History (Most Recent First):");
        while (!rollbackHistory.isEmpty()) {
            System.out.println(rollbackHistory.pop());
        }

        System.out.println("\nUpdated Single Room Availability: " + singleRoomAvailability);
    }
}
