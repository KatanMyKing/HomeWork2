public abstract class Residential extends Property {
    private int parkingLots; // >= 0

    // --- בנאי ---
    public Residential(String address, double area, double price, int parkingLots) {
        super(address, area, price);
        setParkingLots(parkingLots);
    }

    // --- getters & setters ---
    public int getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(int parkingLots) {
        if (parkingLots < 0) {
            this.parkingLots = 0;
        } else {
            this.parkingLots = parkingLots;
        }
    }

    // --- toString ---
    @Override
    public String toString() {
        return super.toString() + ", Parking Lots: " + parkingLots;
    }
}