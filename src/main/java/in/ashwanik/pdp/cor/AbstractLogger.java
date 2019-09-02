package in.ashwanik.pdp.cor;

import java.io.IOException;
import java.io.OutputStream;

abstract class AbstractLogger {

    static int DEBUG = 1;
    static int INFO = 2;
    static int ERROR = 3;
    protected OutputStream outputStream;
    int level;
    private AbstractLogger nextLogger;

    AbstractLogger(OutputStream outputStream, int level) {
        this.outputStream = outputStream;
        this.level = level;
    }


    void setNextLogger(AbstractLogger logger) {
        this.nextLogger = logger;
    }

    void logMessage(int level, String message) throws IOException {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract void write(String message) throws IOException;

}
