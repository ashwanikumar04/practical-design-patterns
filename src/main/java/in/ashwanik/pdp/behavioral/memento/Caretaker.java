package in.ashwanik.pdp.behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;

class Caretaker {
    private Deque<DocumentMemento> states = new ArrayDeque<>();

    void add(DocumentMemento memento) {
        states.push(memento);
    }

    DocumentMemento get() {
        if (states.isEmpty()) {
            throw new IllegalStateException("No states is saved yet");
        }
        return states.pop();
    }
}
