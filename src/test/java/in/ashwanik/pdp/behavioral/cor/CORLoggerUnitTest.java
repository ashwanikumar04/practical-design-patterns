package in.ashwanik.pdp.behavioral.cor;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CORLoggerUnitTest {
    @Test
    public void testLogger() throws IOException {
        //Arrange
        OutputStream outputStream = new ByteArrayOutputStream();
        FileLogger fileLogger = new FileLogger(outputStream, AbstractLogger.ERROR);
        ConsoleLogger consoleLogger = new ConsoleLogger(outputStream, AbstractLogger.DEBUG);
        fileLogger.setNextLogger(consoleLogger);

        //Act
        fileLogger.logMessage(AbstractLogger.ERROR, "This is error");
        fileLogger.logMessage(AbstractLogger.INFO, "This is info");
        fileLogger.logMessage(AbstractLogger.DEBUG, "This is debug");
        String messages = outputStream.toString();

        //Assert
        assertThat(messages).doesNotContain("file:This is info");
    }
}
