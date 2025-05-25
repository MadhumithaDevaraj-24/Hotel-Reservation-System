import java.util.*;

public class HotelSystem {
    static List<Room> rooms = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();
        System.out.println(" Welcome to the Hotel Reservation System!");

        while (true) {
            System.out.println("\n1. View Rooms\n2. Search by Type\n3. Book Room\n4. View Bookings\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: displayRooms(); break;
                case 2: searchByType(); break;
                case 3: bookRoom(); break;
                case 4: viewBookings(); break;
                case 5: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void initializeRooms() {
        rooms.add(new Room(101, "Single", 2000));
        rooms.add(new Room(102, "Double", 3500));
        rooms.add(new Room(103, "Suite", 5000));
        rooms.add(new Room(104, "Double", 3500));
    }

    static void displayRooms() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    static void searchByType() {
        System.out.print("Enter room type (Single/Double/Suite): ");
        String type = scanner.nextLine();

        boolean found = false;
        for (Room room : rooms) {
            if (room.type.equalsIgnoreCase(type) && room.isAvailable) {
                System.out.println(room);
                found = true;
            }
        }

        if (!found) System.out.println("No available rooms of that type.");
    }

    static void bookRoom() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter room number to book: ");
        int roomNum = scanner.nextInt();
        scanner.nextLine();

        for (Room room : rooms) {
            if (room.roomNumber == roomNum && room.isAvailable) {
                System.out.println("Room found. Processing payment of Rs." + room.price + "...");
                room.isAvailable = false;
                bookings.add(new Booking(name, room));
                System.out.println("Booking successful!");
                return;
            }
        }

        System.out.println("Room not available or invalid.");
    }

    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }

        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
