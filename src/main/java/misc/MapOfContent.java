package misc;

import java.util.HashMap;
import java.util.Map;

public class MapOfContent {
    static Map<String, Number> hm = new HashMap<String, Number>();

    public static void main(String[] args) {
        addToMap(hm, Integer.valueOf(3), "An Integer");
        addToMap(hm, Double.valueOf(3.4), "A Double");

        Double d;

        d = (Double) getFromMap(hm, "A Double");
        //d = getFromMap(hm, "A Double");

        System.out.println("Result-> " + d);
    }

    private static void addToMap(Map<String, ? super Number> hashmap, Number c, String key) {
        hashmap.put(key, c);
    }

    private static <T> Number getFromMap(Map<String, ? extends Number> hashmap, String cmsKey) {
        return hashmap.get(cmsKey);
    }
}
