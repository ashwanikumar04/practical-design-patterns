package in.ashwanik.pdp.pub_sub;

interface Publisher {
    String getName();

    <T> void publish(Message<T> message,
                     PublishService publishService);
}
