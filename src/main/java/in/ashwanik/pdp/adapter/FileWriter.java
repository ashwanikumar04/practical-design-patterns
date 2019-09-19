package in.ashwanik.pdp.adapter;

import java.io.OutputStream;

public class FileWriter {

    public void write(OutputStream outputStream, byte[] bytes) {
        DocumentWriter documentWriter = new DocumentWriter(new YamlToJsonDocumentAdapter(new YamlWriterImpl()));
        documentWriter.save(outputStream, bytes);
    }
}
