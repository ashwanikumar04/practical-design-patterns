package in.ashwanik.pdp.behavioral.visitor;

public class HtmlVisitor implements Visitor {

    private StringBuilder output;

    HtmlVisitor() {
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
        output.append("<b>");
        output.append(boldText);
        output.append("</b>");
    }

    @Override
    public void visit(HyperLink hyperLink) {
        output.append("<a");
        output.append(" href='");
        output.append(hyperLink.getUrl());
        output.append("'> ");
        output.append(hyperLink.getText());
        output.append("</a>");
    }
}
