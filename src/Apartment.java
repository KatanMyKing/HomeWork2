public class Apartment extends Residential {
    private int rooms; // >= 2

    // --- בנאי ---
    public Apartment(String address, double area, double price, int parkingLots, int rooms) {
        super(address, area, price, parkingLots);
        setRooms(rooms);
    }

    // --- getters & setters ---
    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        if (rooms < 2) {
            this.rooms = 1; // ברירת מחדל
        } else {
            this.rooms = rooms;
        }
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Apartment: " + super.toString() + ", Rooms: " + rooms;
    }

    // --- מימוש מס ---
    @Override
    public void taxIt() {
        // דירות מגורים – 8%
        double taxValue = getPrice() * 0.08;
        System.out.println("Apartment Tax Payment = " + taxValue);
    }
}