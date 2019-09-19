package in.ashwanik.pdp.adapter;

import java.io.IOException;
import java.io.OutputStream;

interface YamlWriter {

    void write(OutputStream outputStream, byte[] data) throws IOException;

}
