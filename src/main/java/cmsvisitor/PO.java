package cmsvisitor;

import java.util.List;

public class PO extends CMS {
    List<POL> lpol;

    public List<POL> getLpo() {
        return lpol;
    }

    public void setLpo(List<POL> lpol) {
        this.lpol = lpol;
    }

    @Override
    public void accept(Visitor visitor, CC cc) {
        throw new UnsupportedOperationException("Not owned by this object.");
    }

    @Override
    public void accept(Visitor visitor, PO po) {
        throw new UnsupportedOperationException("Cannot attach object to itself.");
    }

    @Override
    public void accept(Visitor visitor, P p) {
        throw new UnsupportedOperationException("Not owned by this object.");
    }

    @Override
    public void accept(Visitor visitor, POL pol) {
        visitor.visit(this, pol);
    }
}