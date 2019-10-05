package in.ashwanik.pdp.structural.adapter;

import java.io.IOException;
import java.io.OutputStream;

public interface JsonWriter {

    void write(OutputStream outputStream,
               byte[] data) throws IOException;

}
