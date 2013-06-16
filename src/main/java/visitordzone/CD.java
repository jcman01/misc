package visitordzone;

public class CD implements Visitable {
    private double price = 2.;
    private double weight = 12.;

    //accept the visitor
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}
