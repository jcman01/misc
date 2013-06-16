package misc;


/*
 * Split string into array based on regex delimiter
 */
public class RegexSplitIntoArray {
    public static void main(String[] args) {
        splitString();
    }

    private static void splitString() {
        String subjectString = "0-30 31-60 61-90 91-120 365+";
        String pattern = "[+-]\\d*\\s*";

        String[] splitArray = subjectString.split(pattern);
        for (String string : splitArray) {
            System.out.println("String: " + string);
        }
    }
}
