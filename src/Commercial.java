public class Commercial extends Property {
    private boolean storeroom;
    private double yield; // לא שלילי, ברירת מחדל 0.0

    // --- בנאי (1) ---
    public Commercial(String address, double area, double price, double yield) {
        super(address, area, price);
        setYield(yield);
        this.storeroom = false; // ברירת מחדל
    }

    // --- בנאי (2) ---
    public Commercial(String address, double area, double price, double yield, boolean storeroom) {
        super(address, area, price);
        setYield(yield);
        this.storeroom = storeroom;
    }

    // --- getters & setters ---
    public boolean isStoreroom() {
        return storeroom;
    }

    public void setStoreroom(boolean storeroom) {
        this.storeroom = storeroom;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        if (yield < 0) {
            this.yield = 0.0;
        } else {
            this.yield = yield;
        }
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Commercial: " + super.toString() +
                ", Storeroom: " + storeroom +
                ", Yield: " + yield + "%";
    }

    // --- פונקציה לחישוב הרווח החודשי לפי התשואה ---
    public void printMonthlyProfit() {
        // רווח חודשי = מחיר * (אחוזי תשואה/100) / 12
        double monthly = getPrice() * (yield / 100.0) / 12.0;
        System.out.println("Monthly profit: " + monthly);
    }

    // --- מימוש מס ---
    @Override
    public void taxIt() {
        // נדל"ן מסחרי - 5%
        double taxValue = getPrice() * 0.05;
        System.out.println("Commercial Tax Payment = " + taxValue);
    }
}