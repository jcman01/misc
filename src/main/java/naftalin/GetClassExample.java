package naftalin;

import java.util.Arrays;
import java.util.List;

public class GetClassExample {
    List<Integer> ints = Arrays.asList(1, 2, 3);
    List<String> strings = Arrays.asList("one", "two");

    /*
     * Because generics are compiled by erasure, at run time the classes
     * List<Integer>, List<String>, and List<List<String>> are implemented
     * by a single class, namely List. You can see this using reflection
     */
    public static void main(String[] args) {
        GetClassExample gce = new GetClassExample();

        if (gce.ints.getClass() == gce.strings.getClass()) {
            System.out.println("equal: " + gce.strings.getClass());
        }
    }
}
