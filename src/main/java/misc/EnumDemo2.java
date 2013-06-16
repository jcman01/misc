package misc;

enum Apple {
    AA, BB, CC, DE, EE
}
public class EnumDemo2 {
    public static void main(String args[]) {
        Apple apple;

        System.out.println("Apple.values()");
        Apple allapples[] = Apple.values();
        for (Apple a : allapples) {
            System.out.println(a);
        }


        apple = Apple.valueOf("AA");
        System.out.println("Apple.valueOf() " + apple);
        System.out.println("apple.name()" + apple.name());
    }
}