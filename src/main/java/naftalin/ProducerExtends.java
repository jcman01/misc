package naftalin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProducerExtends {
    public static void main(String[] args) {
    }

    /*
     * We create an empty list of numbers, and add to it first a list of integers
     * and then a list of doubles:

     * The first call is ok because nums has type List<Number>, which is a
     * subtype of Collection<Number>, and ints has type List<Integer>,
     * which is a subtype of Collection<? extends Number>. The second
     * call is similarly permitted. In both calls, E is taken to be Number.
     *
     * If the method signature for addAll had been written without the
     * wildcard, then the calls to add lists of integers and doubles to
     * a list of numbers would not have been permitted; you would only
     * have been able to add a list that was explicitly declared to be a
     * list of numbers.
     *
     * "addAll" extends
     *
     * public boolean addAll(Collection<? extends E> c);
     *
     */
    public void TwoTwo() {
        List<Number> nums = new ArrayList<Number>();
        List<Integer> ints = Arrays.asList(1, 2);
        List<Double> dbls = Arrays.asList(2.78, 3.14);
        nums.addAll(ints);
        nums.addAll(dbls);
        assert nums.toString().equals("[1, 2, 2.78, 3.14]");
    }

    public void TwoTwo(String text) {
        List<Integer> ints = Arrays.asList(1, 2);
        List<? extends Number> nums = ints;
        /*
         * Cannot add double to a List<? extends Number>, since it might be
         * a list of some other subtype of number.
         *
         */
        // nums.add(3.14);  // compile-time error
        assert ints.toString().equals("[1, 2, 3.14]");  // uh oh!

    }
}
