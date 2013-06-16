package misc;

public class FunctionPointer {
    interface func {
        int fun(int x, int y);

        @Override
        String toString();
    }

    public static void main(String[] args) {
        func add = new func() {
            @Override
            public int fun(int x, int y) {
                return x + y;
            }

            @Override
            public String toString() {
                return "+";
            }
        };
        func mult = new func() {
            @Override
            public int fun(int x, int y) {
                return x * y;
            }

            @Override
            public String toString() {
                return "*";
            }
        };
        func[] arr = {add, mult};
        int i[] = {10, 20, 30, 40};
        for (int val : i) {
            for (func f : arr) {
                System.out.println(val + "" + f + val + "=" + f.fun(val, val));
            }
        }

    }
}