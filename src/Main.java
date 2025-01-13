import java.util.List;
import java.util.Scanner;


public class Main {
    // משתנה גלובלי של מנהל משרד התיווך
    private static RealEstateManager manager;

    public static void main(String[] args) {
        // 1) יצירת מנהל
        manager = new RealEstateManager("Shimon's Real Estate");

        // 2) קבלת נכסים מ-DataManager והכנסתם למנהל
        Property[] initialProperties = DataManager.createProperties();
        for (Property p : initialProperties) {
            manager.addProperty(p);
        }

        // 3) תפריט
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--------------------------------");
            System.out.println("1 > חיפוש נכסים");
            System.out.println("2 > דו\"ח פיננסי (מס לכל נכס)");
            System.out.println("3 > תשואת נדל\"ן מסחרי");
            System.out.println("4 > נכסים לפי עיר");
            System.out.println("5 > כמות ערים");
            System.out.println("0 > יציאה מהתוכנית");
            System.out.println("--------------------------------");
            System.out.print("אנא בחר אופציה: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("נא להזין מספר תקין.");
                continue;
            }

            switch (choice) {
                case 1:
                    propertiesList(sc);
                    break;
                case 2:
                    financialReport();
                    break;
                case 3:
                    commercialYield();
                    break;
                case 4:
                    propertiesByCity(sc);
                    break;
                case 5:
                    numberOfCities();
                    break;
                case 0:
                    System.out.println("יציאה מהתוכנית. להתראות!");
                    sc.close();
                    return;
                default:
                    System.out.println("בחירה לא תקינה, נסה שוב.");
                    break;
            }
        }
    }

    /**
     * (10) חיפוש נכסים עד מחיר מסוים
     * @throws PriceException אם הוזן מספר שלילי
     */
    private static void propertiesList(Scanner sc) {
        System.out.print("הכנס מחיר מירבי: ");
        double maxPrice;
        try {
            maxPrice = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("נא להזין מספר תקין.");
            return;
        }

        try {
            if (maxPrice < 0) {
                throw new PriceException("המחיר שהוזן שלילי!");
            }
            List<Property> result = manager.getPropertiesUpToPrice(maxPrice);
            if (result.isEmpty()) {
                System.out.println("לא נמצאו נכסים עד למחיר המבוקש.");
            } else {
                System.out.println("נכסים עד מחיר " + maxPrice + ":");
                for (Property p : result) {
                    System.out.println(p);
                }
            }
        } catch (PriceException e) {
            System.out.println("שגיאה: " + e.getMessage());
        }
    }

    /**
     * (11) דו"ח פיננסי – הדפסת המס עבור כל נכס
     */
    private static void financialReport() {
        System.out.println("דו\"ח פיננסי - מס עבור כל נכס:");
        for (Property p : manager.getProperties()) {
            System.out.println(p);
            p.taxIt(); // מדפיס את הסכום
            System.out.println("--------------------");
        }
    }

    /**
     * (12) תשואת נדל"ן מסחרי
     * פונקציה המסכמת את התשואה הכוללת של הנכסים המסחריים
     */
    private static void commercialYield() {
        double totalYield = 0.0;
        for (Property p : manager.getProperties()) {
            if (p instanceof Commercial) {
                Commercial c = (Commercial) p;
                totalYield += c.getYield();
            }
        }
        System.out.println("סך התשואה (אחוזים) של כל הנכסים המסחריים: " + totalYield + "%");

        // אם רוצים להדגים את חישוב הרווח החודשי לכל נכס מסחרי:
        System.out.println("\nרווח חודשי לכל נכס מסחרי:");
        for (Property p : manager.getProperties()) {
            if (p instanceof Commercial) {
                Commercial c = (Commercial) p;
                System.out.print(c + " => ");
                c.printMonthlyProfit();
            }
        }
    }

    /**
     * (13) נכסים לפי עיר
     * יש לטפל באותיות קטנות/גדולות, וכן להתעלם ממקף
     */
    private static void propertiesByCity(Scanner sc) {
        System.out.print("הכנס שם עיר לחיפוש: ");
        String userInput = sc.nextLine().trim();

        // הסרת מקף
        userInput = userInput.replace("-", "");
        // lowercase
        userInput = userInput.toLowerCase();

        boolean found = false;
        for (Property p : manager.getProperties()) {
            // ניקח את הכתובת של הנכס, נסיר ממנה מקף, נהפוך ל-lowercase
            String addr = p.getAddress().replace("-", "").toLowerCase();
            // נבדוק אם userInput הוא חלק מהכתובת (מבחינת העיר)
            // נניח שהעיר היא המילה הראשונה, או מחפשים ע"פ contains?
            // ההוראה אומרת "יש לחפש את שם העיר בתוך מחרוזת הכתובת".
            if (addr.contains(userInput)) {
                found = true;
                System.out.println(p);
            }
        }

        if (!found) {
            System.out.println("לא נמצאו נכסים בעיר המבוקשת.");
        }
    }

    /**
     * (14) כמות ערים (NumberOfCities)
     * הפונקציה מדפיסה את מספר הערים השונות ושמותיהן
     */
    private static void numberOfCities() {
        // נעבור על כל הנכסים, נחלץ את העיר מתוך הכתובת
        // נניח שהעיר היא המילים הראשונות עד הפסיק. למשל: "Tel Aviv, Frishman 12"
        // נשתמש ב-Set כדי לאגור ערים שונות
        java.util.Set<String> cities = new java.util.HashSet<>();

        for (Property p : manager.getProperties()) {
            String fullAddress = p.getAddress();
            // נחתוך לפי פסיק
            String[] split = fullAddress.split(",");
            if (split.length > 0) {
                String city = split[0].trim();
                // נסיר מקפים, ונהפוך ל-case אחיד כדי לאחד עיר
                city = city.replace("-", "").toLowerCase();
                // נשמור ב-Set בגירסתו המנורמלת
                cities.add(city);
            }
        }

        System.out.println("נמצאו " + cities.size() + " ערים שונות בנכסים.");
        // אם רוצים להדפיס גם את הערים (אפשר להדפיס בצורתן המקורית, או המנורמלת)
        // כאן נדפיס בצורה המנורמלת (אותיות קטנות, בלי מקף):
        for (String city : cities) {
            System.out.println(city);
        }
    }
}