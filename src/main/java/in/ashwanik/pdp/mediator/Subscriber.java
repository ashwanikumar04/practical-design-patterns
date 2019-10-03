package in.ashwanik.pdp.mediator;

interface Subscriber {
    String getName();

    void receive(Message message);
}
