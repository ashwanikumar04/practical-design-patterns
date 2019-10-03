package in.ashwanik.pdp.mediator;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;

@Slf4j
public class FileSubscriber implements Subscriber {
    private final OutputStream outputStream;
    private final String name;

    FileSubscriber(String name,
                   OutputStream outputStream) {
        this.name = name;
        this.outputStream = outputStream;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void receive(Message message) {
        message.setReceiver(name);
        message.setReceivedOn(System.currentTimeMillis());
        try {
            outputStream.write(message.getBytes());
        } catch (IOException e) {
            log.error("Error occurred", e);
        }
    }
}
