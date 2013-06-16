package misc;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatch {
    private static void match(String REGEX, String INPUT) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println("\nMatch number: " + count);
            System.out.println("start() : " + m.start());
            System.out.println("end()   : " + m.end());
            System.out.println("group() : " + m.group());
        }
    }

    public static void main(String[] args) {
        //match("'?\\w", "ABC'DE'F");

        final String regex = "{\"user_id\" : [0-9]*}";


        match(regex, "ABC'DE'F");
    }
}
