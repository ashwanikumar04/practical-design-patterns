package in.ashwanik.pdp.behavioral.visitor;

interface Visitor {
    void visit(PlainText plainText);

    void visit(BoldText boldText);

    void visit(HyperLink hyperLink);
}
