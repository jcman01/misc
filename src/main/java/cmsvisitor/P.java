package cmsvisitor;

import java.util.List;

public class P extends CMS {
    List<PO> lpo;
    List<CC> lcc;

    public List<PO> getLpo() {
        return lpo;
    }

    public void setLpo(List<PO> lpo) {
        this.lpo = lpo;
    }

    public List<CC> getLcc() {
        return lcc;
    }

    public void setLcc(List<CC> lcc) {
        this.lcc = lcc;
    }

    @Override
    public void accept(Visitor visitor, CC cc) {
        visitor.visit(this, cc);
    }

    @Override
    public void accept(Visitor visitor, PO po) {
        visitor.visit(this, po);
    }

    @Override
    public void accept(Visitor visitor, P p) {
        throw new UnsupportedOperationException("Cannot attach object to itself.");
    }

    @Override
    public void accept(Visitor visitor, POL pol) {
        throw new UnsupportedOperationException("Not owned by this object.");
    }
}