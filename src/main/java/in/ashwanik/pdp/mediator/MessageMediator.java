package in.ashwanik.pdp.mediator;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
class MessageMediator {

    private ConcurrentHashMap<String, List<Subscriber>> subscribers;

    MessageMediator() {
        this.subscribers = new ConcurrentHashMap<>();
    }

    private List<Subscriber> getSubscribersForTopic(String topic) {
        keyNotEmpty(topic);
        return subscribers.getOrDefault(topic, Collections.emptyList());
    }

    void addSubscriber(String topic,
                       Subscriber subscriber) {
        keyNotEmpty(topic);
        objectNotNull(subscriber);
        subscribers.compute(topic, (k, v) -> {
            v = v == null ? new ArrayList<>() : v;
            v.add(subscriber);
            return v;
        });
    }

    void removeSubscriber(String topic,
                          Subscriber subscriber) {
        keyNotEmpty(topic);
        objectNotNull(subscriber);
        subscribers.compute(topic, (k, v) -> {
            v = v == null ? new ArrayList<>() : v;
            for (int index = 0; index < v.size(); index++) {
                if (subscriber.equals(v.get(index))) {
                    v.remove(index);
                    break;
                }
            }
            return v;
        });
    }

    void send(Message message) {
        List<Subscriber> subscribersForTopic = getSubscribersForTopic(message.getTopic());

        if (!subscribersForTopic.isEmpty()) {
            for (Subscriber subscriber : subscribersForTopic) {
                subscriber.receive(message);
            }
        } else {
            log.info("No subscriber for topic {} ", message.getTopic());
        }
    }

    private <T> void objectNotNull(T object) {
        if (object == null) {
            throw new IllegalArgumentException("Param can't be null");
        }
    }

    private void keyNotEmpty(String key) {
        objectNotNull(key);
        if (key.isEmpty()) {
            throw new IllegalArgumentException("Param can't be null");
        }
    }
}
