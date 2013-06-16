package naftalin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConsumerSuper {
    public static void main(String[] args) {
        ConsumerSuper cs = new ConsumerSuper();
        List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
        List<Integer> ints = Arrays.asList(5, 6);

        cs.copy5(objs, ints);
        assert objs.toString().equals("[5, 6, four]");
    }

    /*
     * Copies into a destination list all of the elements from a source list,
     * from the convenience class Collections:
     */
    public <T> void copy(List<? super T> dst, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }

    /*
     * too restrictive - only permits calls when the dest and source have exactly
     * the same type
     */
    public <T> void copy2(List<T> dst, List<T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }

    /*
     * Works only when the type parameter is Object
     */
    public <T> void copy3(List<T> dst, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }

    /*
     * Works only when the type parameter is Integer
     */
    public <T> void copy4(List<? super T> dst, List<T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }

    /*
     * Works for all three type parameters i.e., Object,
     * Number, and Integer
     */
    public <T> void copy5(List<? super T> dst, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }
}
