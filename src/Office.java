public class Office extends Property {

    // --- בנאי ---
    public Office(String address, double area, double price) {
        super(address, area, price);
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Office: " + super.toString();
    }

    // --- מימוש מס ---
    @Override
    public void taxIt() {
        // משרד - 5%
        double taxValue = getPrice() * 0.05;
        System.out.println("Office Tax Payment = " + taxValue);
    }
}