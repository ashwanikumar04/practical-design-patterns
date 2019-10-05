package in.ashwanik.pdp.others.pub_sub;

interface Subscriber {
    String getName();

    <T> void receive(Message<T> message);
}
