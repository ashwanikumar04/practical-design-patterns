package in.ashwanik.pdp.behavioral.mediator;

interface Publisher {
    String getName();

    void publish(Message message);
}
