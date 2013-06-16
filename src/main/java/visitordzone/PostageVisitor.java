package visitordzone;

public class PostageVisitor implements Visitor {
    private double totalPostageForCart;

    @Override
    public void visit(Book book) {
        if (book.getPrice() < 10.0) {
            totalPostageForCart += book.getWeight() * 2;
        }
    }

    @Override
    public void visit(CD cd) {
        if (cd.getPrice() < 10.0) {
            totalPostageForCart += cd.getWeight() * 2;
        }
    }

    @Override
    public void visit(DVD dvd) {
        if (dvd.getPrice() < 10.0) {
            totalPostageForCart += dvd.getWeight() * 2;
        }
    }

    public double getTotalPostage() {
        return totalPostageForCart;
    }
}
