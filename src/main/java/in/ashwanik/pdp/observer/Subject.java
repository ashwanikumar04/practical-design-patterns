package in.ashwanik.pdp.observer;

import java.util.ArrayList;
import java.util.List;


public class Subject {

    private List<Observer> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public <T> void update(Event<T> event) {
        observers.forEach(x -> x.onNotify(event));
    }
}
