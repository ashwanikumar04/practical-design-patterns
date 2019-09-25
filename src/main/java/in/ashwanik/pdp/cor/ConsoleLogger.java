package in.ashwanik.pdp.cor;


import java.io.IOException;
import java.io.OutputStream;

class ConsoleLogger extends AbstractLogger {

    ConsoleLogger(OutputStream outputStream,
                  int level) {
        super(outputStream, level);
    }

    @Override
    void write(String message) throws IOException {
        outputStream.write(("console: " + message).getBytes());
        outputStream.write("\n".getBytes());
    }
}
