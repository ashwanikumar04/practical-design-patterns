package in.ashwanik.pdp.behavioral.visitor;

import lombok.Getter;

@Getter
class HyperLink extends DocumentPart {
    private String url;

    HyperLink(String text,
              String url) {
        super(text);
        this.url = url;
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
