package in.ashwanik.pdp.others.pub_sub;

class SubscribeService {

    private Broker broker;

    public SubscribeService(Broker broker) {
        this.broker = broker;
    }

    void subscribe(Subscriber subscriber,
                   String topic) {
        broker.addSubscriber(topic, subscriber);
    }

    void unsubscribe(Subscriber subscriber,
                     String topic) {
        broker.removeSubscriber(topic, subscriber);
    }

}
