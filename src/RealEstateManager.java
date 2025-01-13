import java.util.ArrayList;
import java.util.List;


public class RealEstateManager {
    private String name;
    private List<Property> properties; // מערך דינמי של נכסים

    // --- בנאי ---
    public RealEstateManager(String name) {
        this.name = name;
        this.properties = new ArrayList<>();
    }

    // --- getters & setters ---
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    // --- פונקציה להוספת נכס ---
    public void addProperty(Property p) {
        properties.add(p);
    }

    // --- פונקציה המחזירה מערך נכסים שערכם עד מחיר מסוים ---
    public List<Property> getPropertiesUpToPrice(double maxPrice) {
        List<Property> result = new ArrayList<>();
        for (Property p : properties) {
            if (p.getPrice() <= maxPrice) {
                result.add(p);
            }
        }
        return result;
    }

    // --- פונקציה המחזירה את הסכום הכולל של הנכסים ---
    public double getTotalPrice() {
        double sum = 0.0;
        for (Property p : properties) {
            sum += p.getPrice();
        }
        return sum;
    }
}