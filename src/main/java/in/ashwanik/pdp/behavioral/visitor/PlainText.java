package in.ashwanik.pdp.behavioral.visitor;

public class PlainText extends DocumentPart {
    PlainText(String text) {
        super(text);
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
