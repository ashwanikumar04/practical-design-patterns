package in.ashwanik.pdp.behavioral.memento;

import in.ashwanik.pdp.common.utils.Json;

public class Originator {
    private Document state;

    public void setState(Document state) {
        this.state = state;
    }

    public Document getState() {
        return state;
    }

    public DocumentMemento createMemento() {
        return new DocumentMemento(state);
    }

    public void setMemento(DocumentMemento memento) {
        state = Json.deserialize(memento.getDocument(), Document.class);
    }
}
