package in.ashwanik.pdp.memento;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DocumentMementoUnitTest {
    @Test
    public void testDocumentMemento() {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        Document document = new Document();
        document.add(new DocumentPart("name1"));
        document.add(new DocumentPart("name2"));

        originator.setState(document);
        caretaker.add(originator.createMemento());

        document.add(new DocumentPart("name3"));

        originator.setMemento(caretaker.get());

        assertThat(originator.getState()).isNotNull();
        assertThat(originator.getState().getParts().size()).isEqualTo(2);
    }
}
