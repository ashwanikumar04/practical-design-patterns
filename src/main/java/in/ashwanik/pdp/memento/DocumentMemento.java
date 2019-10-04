package in.ashwanik.pdp.memento;

import in.ashwanik.pdp.common.utils.Json;
import lombok.Getter;

@Getter
class DocumentMemento {
    private String document;

    DocumentMemento(Document document) {
        this.document = Json.serialize(document);
    }
}
