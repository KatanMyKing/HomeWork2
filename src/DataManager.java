public class DataManager {

    /**
     * הפונקציה יוצרת ומחזירה מערך של נכסים:
     * 2 מגרשים, 2 דירות מגורים, 2 וילות, 2 דירות נופש, 2 נדל"ן מסחרי, 2 משרדים
     */
    public static Property[] createProperties() {
        Property[] arr = new Property[12];

        // 2 מגרשים
        arr[0] = new Plot("Tel Aviv, Frishman 12", 500, 2000000, TYPE.URBAN);
        arr[1] = new Plot("Ramat Gan, Bialik 23", 1000, 3000000, TYPE.AGRICULTURAL);

        // 2 דירות מגורים (Apartment)
        arr[2] = new Apartment("Kfar Saba, Weitzman 18", 90, 1500000, 1, 3);
        arr[3] = new Apartment("Holon, Balfour 10", 100, 1200000, 2, 4);

        // 2 וילות
        arr[4] = new Villa("Herzliya, HaNassi 5", 300, 3500000, 2, 2);
        arr[5] = new Villa("Ra'anana, HaTamar 8", 250, 3000000, 1, 3);

        // 2 דירות נופש
        arr[6] = new Vacation("Eilat, HaYam 7", 80, 1000000, 0, 6);
        arr[7] = new Vacation("Tiberias, HaGdud 15", 70, 800000, 1, 4);

        // 2 נדל"ן מסחרי
        arr[8] = new Commercial("Petah Tikva, Jabotinsky 100", 200, 2000000, 12.5);
        arr[9] = new Commercial("Haifa, Hachalutz 33", 350, 4000000, 7.5, true);

        // 2 משרדים
        arr[10] = new Office("Jerusalem, King George 20", 120, 1400000);
        arr[11] = new Office("Beer Sheva, Rager Blvd 50", 200, 1800000);

        return arr;
    }
}