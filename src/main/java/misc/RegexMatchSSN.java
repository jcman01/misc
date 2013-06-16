package misc;

import java.util.ArrayList;

public class RegexMatchSSN {
    private static void matchSSN() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("123-45-6789");
        list.add("9876-5-4321");
        list.add("987-65-4321 (attack)");
        list.add("987-65-4321 ");
        list.add("192-83-7465");

        for (String ssn : list) {
            if (ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")) {
                System.out.println("Found good SSN: " + ssn);
            }
        }
    }

    public static void main(String[] args) {
        matchSSN();
    }
}
