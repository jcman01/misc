package naftalin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCardCapture {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);

        for (Integer integer : ints) {
            System.out.println(integer);
        }

        reverse(ints);
        for (Integer integer2 : ints) {
            System.out.println(integer2);
        }

        reverse2(ints);
        for (Integer integer2 : ints) {
            System.out.println(integer2);
        }
    }


    /*
     * Type variable T in "rev" has captured the wildcard. This is a generally
     * useful technique when dealing with wildcards, and it is worth
     * knowing.
     */
    public static void reverse(List<?> list) {
        rev(list);
    }

    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }

    private static <T> void reverse2(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }
}
