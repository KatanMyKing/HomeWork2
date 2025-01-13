public class Vacation extends Residential {
    private int guests; // >= 1

    // --- בנאי ---
    public Vacation(String address, double area, double price, int parkingLots, int guests) {
        super(address, area, price, parkingLots);
        setGuests(guests);
    }

    // --- getters & setters ---
    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        if (guests < 1) {
            this.guests = 1; // ברירת מחדל
        } else {
            this.guests = guests;
        }
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Vacation: " + super.toString() + ", Guests: " + guests;
    }

    // --- מימוש מס ---
    @Override
    public void taxIt() {
        // דירת נופש – 25%
        double taxValue = getPrice() * 0.25;
        System.out.println("Vacation Tax Payment = " + taxValue);
    }
}