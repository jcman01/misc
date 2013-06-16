package naftalin;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {

        List<Integer> ints = Lists.toList(new Integer[]{1, 2, 3});
        for (Integer integer : ints) {
            System.out.println(integer);
        }

        List<String> words = Lists.toList(new String[]{"hello", "world"});
        for (String string : words) {
            System.out.println(string);
        }

//--------

        List<Integer> ints2 = Lists.toList2(1);
        for (Integer integer : ints2) {
            System.out.println(integer);
        }

        List<String> words2 = Lists.toList2("hello", "world");
        for (String string : words2) {
            System.out.println(string);
        }
    }

    public static <T> List<T> toList(T[] arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) {
            list.add(elt);
        }
        return list;
    }

    public static <T> List<T> toList2(T... arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) {
            list.add(elt);
        }
        return list;
    }
}
