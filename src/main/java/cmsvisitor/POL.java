package cmsvisitor;

public class POL extends CMS {
    @Override
    public void accept(Visitor visitor, CC cc) {
        throw new UnsupportedOperationException("Not owned by this object.");
    }

    @Override
    public void accept(Visitor visitor, PO po) {
        throw new UnsupportedOperationException("Not owned by this object.");
    }

    @Override
    public void accept(Visitor visitor, P p) {
        throw new UnsupportedOperationException("Not owned by this object.");
    }

    @Override
    public void accept(Visitor visitor, POL pol) {
        throw new UnsupportedOperationException("Cannot attach object to itself.");
    }
}
