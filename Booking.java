public class Booking {
    String customerName;
    Room room;

    public Booking(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
    }

    public String toString() {
        return customerName + " booked Room #" + room.roomNumber + " (" + room.type + ")";
    }
}
