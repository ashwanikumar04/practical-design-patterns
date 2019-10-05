package in.ashwanik.pdp.behavioral.cor;


import java.io.IOException;
import java.io.OutputStream;

class FileLogger extends AbstractLogger {

    FileLogger(OutputStream outputStream,
               int level) {
        super(outputStream, level);
    }

    @Override
    void write(String message) throws IOException {
        outputStream.write(("file: " + message).getBytes());
        outputStream.write("\n".getBytes());
    }
}
