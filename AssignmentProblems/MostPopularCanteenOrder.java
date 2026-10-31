import java.util.HashMap;
import java.util.Map;

public class MostPopularCanteenOrder {

    static String[] mostPopular(String[] orders) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String item : orders) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        String bestItem = orders[0];
        int maxCount = map.get(bestItem);

        for (String item : orders) {
            int count = map.get(item);

            if (count > maxCount) {
                maxCount = count;
                bestItem = item;
            }
        }

        return new String[]{bestItem, String.valueOf(maxCount)};
    }

    public static void main(String[] args) {
        String[] orders = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };

        String[] result = mostPopular(orders);

        System.out.println("Most Popular Item: " + result[0]);
        System.out.println("Count: " + result[1]);
    }
}