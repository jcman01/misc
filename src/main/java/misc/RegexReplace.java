package misc;

public class RegexReplace {
    public static void main(String[] args) {
        String str = "ABC'DE'F";

        str = str.replaceAll("('?\\w)", "^$1");
        System.out.println("" + str);
    }
}