package bloch;

import java.util.HashMap;
import java.util.Map;
import misc.Ad;

public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        favorites.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Ad mb = new Ad();
        mb.setCms_key1("5454");


        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 3);
        f.putFavorite(Ad.class, mb);

        String s = f.getFavorite(String.class);
        int i = f.getFavorite(Integer.class);
        Ad beanClass = f.getFavorite(Ad.class);
        System.out.println(s + "\n");
        System.out.println(i + "\n");
        System.out.println(beanClass.toString());
    }
}