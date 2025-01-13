public class Villa extends Residential {
    private int levels; // >= 1

    // --- בנאי ---
    public Villa(String address, double area, double price, int parkingLots, int levels) {
        super(address, area, price, parkingLots);
        setLevels(levels);
    }

    // --- getters & setters ---
    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        if (levels < 1) {
            this.levels = 1; // ברירת מחדל
        } else {
            this.levels = levels;
        }
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Villa: " + super.toString() + ", Levels: " + levels;
    }

    // --- מימוש מס ---
    @Override
    public void taxIt() {
        // וילה – 8%
        double taxValue = getPrice() * 0.08;
        System.out.println("Villa Tax Payment = " + taxValue);
    }
}