package in.ashwanik.pdp.visitor;

public class BoldText extends DocumentPart {
    BoldText(String text) {
        super(text);
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
