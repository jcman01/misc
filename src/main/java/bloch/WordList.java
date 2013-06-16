package bloch;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;


/*
 * The following program relies on the fact that String implements Comparable
 *
 * By implementing Comparable, you allow your class to interoperate with all of
 * the many generic algorithms and collection implementations that depend on
 * this interface
 */
public class WordList {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>();
        String[] testStr = {"ralph", "smooch", "gooch", "alpha", "gamma"};

        Collections.addAll(set, testStr);
        System.out.println(set);
    }
}