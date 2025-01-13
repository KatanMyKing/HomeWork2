public abstract class Property {
    // --- משתנים פרטיים ---
    private String address;
    private double area;
    private double price;

    // --- בנאי ---
    public Property(String address, double area, double price) {
        setAddress(address);
        setArea(area);
        setPrice(price);
    }

    // --- getters & setters ---

    /**
     * הגדרת כתובת
     * @param address לא null, לא ריק, מכיל לפחות שתי מילים
     */
    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            this.address = "Na, na";
        } else {
            // בדיקה אם יש לפחות שתי מילים
            String[] parts = address.trim().split("\\s+");
            if (parts.length < 2) {
                this.address = "Na, na";
            } else {
                this.address = address;
            }
        }
    }

    public String getAddress() {
        return address;
    }

    /**
     * הגדרת שטח
     * @param area לא שלילי
     */
    public void setArea(double area) {
        if (area < 0) {
            this.area = 0;
        } else {
            this.area = area;
        }
    }

    public double getArea() {
        return area;
    }

    /**
     * הגדרת מחיר
     * @param price לא שלילי
     */
    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public double getPrice() {
        return price;
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Address: " + address + ", Area: " + area + ", Price: " + price;
    }

    // --- פונקציה אבסטרקטית לחישוב מס ---
    public abstract void taxIt();
}