package in.ashwanik.pdp.visitor;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DocumentUnitTest {
    @Test
    public void testDocumentConverter() {
        Document document = new Document();
        document.add(new PlainText("hello"));
        document.add(new BoldText("hello"));
        document.add(new HyperLink("hello", "http://google.com"));

        HtmlVisitor visitor = new HtmlVisitor();
        document.generate(visitor);
        assertThat(visitor.getOutput()).isNotBlank();
    }
}
