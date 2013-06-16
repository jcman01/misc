package visitordzone;

public class DVD implements Visitable {
    private double price = 1.;
    private double weight = 116.;

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
