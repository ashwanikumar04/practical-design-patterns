package in.ashwanik.pdp.behavioral.mediator;

interface Subscriber {
    String getName();

    void receive(Message message);
}
