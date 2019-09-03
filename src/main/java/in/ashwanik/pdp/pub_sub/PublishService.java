package in.ashwanik.pdp.pub_sub;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
class PublishService {
    private Broker broker;

    public PublishService(Broker broker) {
        this.broker = broker;
    }

    <T> void publish(Message<T> message) {

        List<Subscriber> subscribers = broker.getSubscribersForTopic(message.getTopic());

        if (!subscribers.isEmpty()) {
            for (Subscriber subscriber : subscribers) {
                subscriber.receive(message);
            }
        } else {
            log.info("No subscriber for topic {} ", message.getTopic());
        }
    }
}
