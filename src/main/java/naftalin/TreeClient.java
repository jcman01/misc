package naftalin;

class TreeClient {
    public static <T> String toString(Tree<T> t) {
        return t.visit(new Tree.Visitor<T, String>() {
            @Override
            public String leaf(T e) {
                return e.toString();
            }

            @Override
            public String branch(String l, String r) {
                return "(" + l + "^" + r + ")";
            }
        });
    }

    public static <N extends Number> double sum(Tree<N> t) {
        return t.visit(new Tree.Visitor<N, Double>() {
            @Override
            public Double leaf(N e) {
                return e.doubleValue();
            }

            @Override
            public Double branch(Double l, Double r) {
                return l + r;
            }
        });
    }

    public static void main(String[] args) {
        Tree<Integer> t =
                Tree.branch(Tree.branch(Tree.leaf(1),
                Tree.leaf(2)),
                Tree.leaf(3));
        assert toString(t).equals("((1^2)^3)");
        assert sum(t) == 6;
        System.out.println("toString " + toString(t));
        System.out.println("Sum " + sum(t));
    }
}
