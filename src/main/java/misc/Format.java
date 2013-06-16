package misc;

public class Format {
    public static void main(String[] args) {
        String format = "|%1$-10s|%2$-10s|%3$-20s|\n";
        System.out.format(format, "FirstName", "Init.", "LastName");
        System.out.format(format, "Real", "", "Gagnon");
        System.out.format(format, "John", "D", "Doe");
        String ex[] = {"John", "F.", "Kennedy"};
        System.out.format(String.format(format, (Object[]) ex));
    }
}
