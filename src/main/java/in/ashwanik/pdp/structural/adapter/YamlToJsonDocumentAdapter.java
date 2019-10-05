package in.ashwanik.pdp.structural.adapter;

import java.io.IOException;
import java.io.OutputStream;

public class YamlToJsonDocumentAdapter implements JsonWriter {
    private YamlWriter yamlWriter;

    public YamlToJsonDocumentAdapter(YamlWriter yamlWriter) {
        this.yamlWriter = yamlWriter;
    }

    @Override
    public void write(OutputStream outputStream,
                      byte[] data) throws IOException {
        yamlWriter.write(outputStream, data);
    }
}
