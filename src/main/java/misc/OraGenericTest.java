package misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class OraGenericTest {
    public static void main(String[] args) {

        // T inferred to be Object
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<Object>();
        fromArrayToCollection(oa, co);


        // T inferred to be String
        String[] sa = new String[100];
        Collection<String> cs = new ArrayList<String>();
        fromArrayToCollection(sa, cs);

        // T inferred to be Object
        fromArrayToCollection(sa, co);

        Integer[] ia = new Integer[100];
        Float[] fa = new Float[100];
        Number[] na = new Number[100];
        Collection<Number> cn = new ArrayList<Number>();

        // T inferred to be Number
        fromArrayToCollection(ia, cn);

        // T inferred to be Number
        fromArrayToCollection(fa, cn);

        // T inferred to be Number
        fromArrayToCollection(na, cn);

        // T inferred to be Object
        fromArrayToCollection(na, co);

        // compile-time error
        //fromArrayToCollection(na, cs);

        System.out.println("done");
    }

    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o);
        }
    }

    static <T> void fromCMSToCollection(T a, Map<String, T> c) {
        c.put(a.toString(), a);
    }
}
