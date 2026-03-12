import java.util.ArrayList;
import java.util.List;

public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        // Step 1: Create a List to store booking records (Simulation of history)
        List<String> bookingHistory = new ArrayList<>();

        // Step 2: Add confirmed bookings to the history list
        bookingHistory.add("Guest: Abhi, Room Type: Single");
        bookingHistory.add("Guest: Subha, Room Type: Double");
        bookingHistory.add("Guest: Vanmathi, Room Type: Suite");

        // Step 3: Print the Report
        System.out.println("Booking History and Reporting\n");
        System.out.println("Booking History Report");

        for (String record : bookingHistory) {
            System.out.println(record);
        }
    }
}
