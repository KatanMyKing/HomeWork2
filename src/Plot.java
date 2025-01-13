public class Plot extends Property {
    private TYPE type; // URBAN, AGRICULTURAL, INDUSTRIAL

    // --- בנאי ---
    public Plot(String address, double area, double price, TYPE type) {
        super(address, area, price);
        this.type = type;
    }

    // --- getter & setter ---
    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Plot (" + type + "): " + super.toString();
    }

    // --- מימוש המס לפי סוג המגרש ---
    @Override
    public void taxIt() {
        double taxPercentage = 0.0;
        switch (type) {
            case URBAN:
                taxPercentage = 0.10; // 10%
                break;
            case INDUSTRIAL:
                taxPercentage = 0.05; // 5%
                break;
            case AGRICULTURAL:
                taxPercentage = 0.02; // 2%
                break;
        }
        double taxValue = getPrice() * taxPercentage;
        System.out.println("Plot Tax Payment = " + taxValue);
    }
}