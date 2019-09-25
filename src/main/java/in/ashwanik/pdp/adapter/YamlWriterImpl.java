package in.ashwanik.pdp.adapter;

import java.io.IOException;
import java.io.OutputStream;

public class YamlWriterImpl implements YamlWriter {
    @Override
    public void write(OutputStream outputStream,
                      byte[] data) throws IOException {
        outputStream.write(data);
    }
}
