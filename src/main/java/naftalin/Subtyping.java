package naftalin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subtyping {
    public static void main(String[] args) {
        // Integer and Double are sub-types of Number
        List<Number> listNums = new ArrayList<Number>();
        listNums.add(2);
        listNums.add(3.14);
        System.out.println(listNums);
        assert listNums.toString().equals("[2, 3.14]");

        // But List<Integer> is NOT a subtype of List<Number>.
        List<Integer> listIntegers = Arrays.asList(1, 2);
        //List<Number> listNumbers = listIntegers;  // compile-time error
        //listNumbers.add(3.14);
        assert listIntegers.toString().equals("[1, 2, 3.14]");  // uh oh!
    }
}
