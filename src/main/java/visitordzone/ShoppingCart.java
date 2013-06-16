package visitordzone;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Visitable> items;

    public double calculatePostage() {
        PostageVisitor visitor = new PostageVisitor();

        for (Visitable item : items) {
            item.accept(visitor);
        }
        return visitor.getTotalPostage();
    }

    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();
        sc.items = new ArrayList<Visitable>();
        sc.items.add(new Book());
        sc.items.add(new CD());
        System.out.println("Postage: " + sc.calculatePostage());
    }
}