package bloch;

import java.util.ArrayList;
import java.util.List;

public class Generic112 {
    // Uses raw type (List) - fails at runtime!
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        unsafeAdd(strings, new Integer(42));
        String s = strings.get(0); // Compiler-generated cast
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
