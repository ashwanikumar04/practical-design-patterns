package in.ashwanik.pdp.behavioral.memento;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
class Document {
    private List<DocumentPart> parts;

    Document() {
        parts = new ArrayList<>();
    }

    void add(DocumentPart documentPart) {
        parts.add(documentPart);
    }
}
