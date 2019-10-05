package in.ashwanik.pdp.others.pub_sub;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PubSubUnitTest {
    @Test
    public void testPubSub() {
        Broker broker = new Broker();
        SubscribeService subscribeService = new SubscribeService(broker);
        PublishService publishService = new PublishService(broker);

        OutputStream outputStream = new ByteArrayOutputStream();

        Subscriber fileSubscriber = new FileSubscriber("Sub1", outputStream);
        subscribeService.subscribe(fileSubscriber, "topic1");

        Message<String> message = new Message<>();
        message.setPayload("test message");
        message.setTopic("topic1");

        publishService.publish(message);

        String messages = outputStream.toString();

        //Assert
        assertThat(messages).contains("test message");
    }
}
