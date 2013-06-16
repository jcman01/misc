package visitordzone;

//concrete element
public class Book implements Visitable {
    private double price = 8.;
    private double weight = 16.;

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
