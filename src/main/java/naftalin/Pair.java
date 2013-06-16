package naftalin;

/*
 * In a generic class, type parameters appear in the header that declares the
 * class, but not in the constructor
 */
public class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<String, Integer>("one", 2);
        assert pair.getFirst().equals("one") && pair.getSecond() == 2;


        /*
         * A common mistake is to forget the type parameters when invoking
         * the constructor.  Produces a compiler warning
         */
        Pair<String, Integer> pair2 = new Pair("one", 2);
    }
}
