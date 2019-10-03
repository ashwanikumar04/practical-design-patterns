package in.ashwanik.pdp.mediator;

interface Publisher {
    String getName();

    void publish(Message message);
}
