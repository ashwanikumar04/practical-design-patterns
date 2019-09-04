package in.ashwanik.pdp.observer;

public interface Observer {
    <T> void onNotify(Event<T> event);
}
