package in.ashwanik.pdp.pub_sub;

interface Subscriber {
    String getName();

    <T> void receive(Message<T> message);
}
