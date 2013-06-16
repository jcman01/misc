package naftalin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MoreGetAndPut {
    public static void main(String[] args) {

        // producer
        List<Integer> ints_p = Arrays.asList(1, 2, 3);
        assert sum(ints_p) == 6.0;

        List<Double> doubles_p = Arrays.asList(2.78, 3.14);
        assert sum(doubles_p) == 5.92;

        List<Number> nums_p = Arrays.<Number>asList(1, 2, 2.78, 3.14);
        assert sum(nums_p) == 8.92;



        // consumer
        List<Integer> ints_c = new ArrayList<Integer>();
        count(ints_c, 5);
        assert ints_c.toString().equals("[0, 1, 2, 3, 4]");

        List<Number> nums_c = new ArrayList<Number>();
        count(nums_c, 5);
        nums_c.add(5.0);
        assert nums_c.toString().equals("[0, 1, 2, 3, 4, 5.0]");

        List<Object> objs_c = new ArrayList<Object>();
        count(objs_c, 5);
        objs_c.add("five");
        assert objs_c.toString().equals("[0, 1, 2, 3, 4, five]");
    }


    /*
     * Producer extends
     *
     * Whenever you use an iterator, you get values out of a structure, so use
     * an extends wildcard.
     *
     * Method takes a collection of numbers, converts each to a double, and sums them up:
     *
     */
    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number num : nums) {
            s += num.doubleValue();
        }
        return s;
    }

    /*
     * Consumer super
     *
     * Whenever you use the add method, you put values into a structure, so use
     * a super wildcard.
     *
     * Method takes a collection of numbers and an integer n, and
     * puts the first n integers, starting from zero, into the collection:
     *
     */
    public static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) {
            ints.add(i);
        }
    }
}
