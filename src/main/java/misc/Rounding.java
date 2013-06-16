package misc;

public class Rounding {
    public static void main(String[] args) {
        double d = 0.08095238095238096;
        d = (long) (d * 100000) / 100000.0;
        System.out.println(d);
    }
}
