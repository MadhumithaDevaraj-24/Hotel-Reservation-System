public class Room {
    int roomNumber;
    String type;
    double price;
    boolean isAvailable;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = true;
    }

    public String toString() {
        return "Room #" + roomNumber + " [" + type + "] - Rs." + price + " - " +
               (isAvailable ? "Available" : "Booked");
    }
}
