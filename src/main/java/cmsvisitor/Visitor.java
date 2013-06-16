package cmsvisitor;

public interface Visitor {
    public void visit(P parent, PO child);

    public void visit(P parent, CC child);

    public void visit(PO parent, POL child);
}