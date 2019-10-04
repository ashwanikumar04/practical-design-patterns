package in.ashwanik.pdp.visitor;

public class MarkDownVisitor implements Visitor {

    private StringBuilder output;

    MarkDownVisitor() {
        output = new StringBuilder();
    }

    String getOutput() {
        return output.toString();
    }

    @Override
    public void visit(PlainText plainText) {
        output.append(plainText.getText());
    }

    @Override
    public void visit(BoldText boldText) {
        output.append("**");
        output.append(boldText);
        output.append("**");
    }

    @Override
    public void visit(HyperLink hyperLink) {
        output.append("[");
        output.append(hyperLink.getUrl());
        output.append("]");
        output.append("(");
        output.append(hyperLink.getText());
        output.append(")");
    }
}
