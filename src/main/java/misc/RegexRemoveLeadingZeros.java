package misc;

public class RegexRemoveLeadingZeros {
    public static void main(String[] args) {
        removeLeadingZeros("0000000000000012");
    }

    private static void removeLeadingZeros(String number) {
        System.out.println(number.replaceAll("^0+", ""));
    }
}
