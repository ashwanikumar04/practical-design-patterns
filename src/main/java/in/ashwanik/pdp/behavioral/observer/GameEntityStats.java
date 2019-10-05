package in.ashwanik.pdp.behavioral.observer;


public class GameEntityStats extends Subject {

    public void updateStats(GameEntity entity) {
        update(new Event<>(entity));
    }
}
