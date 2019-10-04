package in.ashwanik.pdp.visitor;

import java.util.ArrayList;
import java.util.List;

class Document {
    private List<DocumentPart> parts;

    Document() {
        parts = new ArrayList<>();
    }

    void add(DocumentPart documentPart) {
        parts.add(documentPart);
    }

    void clear() {
        parts.clear();
    }

    void generate(Visitor visitor) {
        parts.forEach(x -> x.accept(visitor));
    }
}
