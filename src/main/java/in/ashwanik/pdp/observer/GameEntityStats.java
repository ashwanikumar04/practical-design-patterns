package in.ashwanik.pdp.observer;


public class GameEntityStats extends Subject {

    public void updateStats(GameEntity entity) {
        update(new Event<>(entity));
    }
}
