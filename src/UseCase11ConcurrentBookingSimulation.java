import java.util.*;

class ConcurrentBookingProcessor implements Runnable {
    private Queue<String> bookingQueue;
    private Map<String, Integer> inventory;
    private final Object lock = new Object();

    public ConcurrentBookingProcessor(Queue<String> bookingQueue, Map<String, Integer> inventory) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        while (true) {
            String request;
            synchronized (bookingQueue) {
                if (bookingQueue.isEmpty()) break;
                request = bookingQueue.poll();
            }

            if (request != null) {
                processBooking(request);
            }
        }
    }

    private void processBooking(String request) {
        String[] parts = request.split(":");
        String guestName = parts[0];
        String roomType = parts[1];

        synchronized (inventory) {
            int count = inventory.get(roomType);
            if (count > 0) {
                inventory.put(roomType, count - 1);
                // Simulating Room ID generation
                String roomId = roomType + "-" + (5 - (count - 1));
                System.out.println("Booking confirmed for Guest: " + guestName + ", Room ID: " + roomId);
            }
        }
    }
}

public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) {
        System.out.println("Concurrent Booking Simulation");

        // Shared Resources
        Queue<String> bookingQueue = new LinkedList<>();
        bookingQueue.add("Abhi:Single");
        bookingQueue.add("Vanmathi:Double");
        bookingQueue.add("Kural:Suite");
        bookingQueue.add("Subha:Single");

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        // Create booking processor tasks
        Thread t1 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory));
        Thread t2 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory));

        // Start concurrent processing
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.get("Single"));
        System.out.println("Double: " + inventory.get("Double"));
        System.out.println("Suite: " + inventory.get("Suite"));
    }
}
