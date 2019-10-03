package in.ashwanik.pdp.mediator;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MediatorUnitTest {
    @Test
    public void testMediator() {
        MessageMediator messageMediator = new MessageMediator();

        OutputStream outputStream = new ByteArrayOutputStream();

        Subscriber fileSubscriber = new FileSubscriber("Sub1", outputStream);
        messageMediator.addSubscriber("topic1", fileSubscriber);

        Message message = new Message();
        message.setPayload("test message");
        message.setTopic("topic1");

        Publisher publisher = new MessagePublisher("message_publisher", messageMediator);

        publisher.publish(message);

        String messages = outputStream.toString();

        //Assert
        assertThat(messages).contains("test message");
    }
}
