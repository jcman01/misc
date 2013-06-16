package cmsvisitor;

public class AttachVisitor implements Visitor {
    @Override
    public void visit(P parent, PO child) {
        parent.getLpo().add(child);
    }

    @Override
    public void visit(P parent, CC child) {
        parent.getLcc().add(child);
    }

    @Override
    public void visit(PO parent, POL child) {
        parent.accept(this, child);
    }
}
