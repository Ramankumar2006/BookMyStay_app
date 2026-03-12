import java.util.Scanner;

// Custom Exception for domain-specific errors
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Mock classes to match the architecture in your image
class RoomInventory {}
class ReservationValidator {
    void validate(String roomType) throws InvalidBookingException {
        // Case-sensitive validation as per requirement
        if (!(roomType.equals("Single") || roomType.equals("Double") || roomType.equals("Suite"))) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
    }
}
class BookingRequestQueue {}

public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        System.out.println("Booking Validation");
        Scanner scanner = new Scanner(System.in);

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            System.out.print("Enter guest name: ");
            String name = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Trigger validation
            validator.validate(roomType);

            System.out.println("Booking successful for " + name);

        } catch (InvalidBookingException e) {
            // Handle domain-specific validation errors
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
