package in.ashwanik.pdp.behavioral.observer;

public interface Observer {
    <T> void onNotify(Event<T> event);
}
