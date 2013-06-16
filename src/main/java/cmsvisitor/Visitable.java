package cmsvisitor;

public interface Visitable {
    public void accept(Visitor visitor, PO po);

    public void accept(Visitor visitor, P p);

    public void accept(Visitor visitor, CC cc);

    public void accept(Visitor visitor, POL pol);
}