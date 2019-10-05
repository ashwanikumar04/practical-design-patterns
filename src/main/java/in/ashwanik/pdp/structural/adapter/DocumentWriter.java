package in.ashwanik.pdp.structural.adapter;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;

@AllArgsConstructor
public class DocumentWriter {
    private JsonWriter jsonWriter;

    public void save(OutputStream outputStream,
                     byte[] data) {
        try {
            jsonWriter.write(outputStream, data);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
