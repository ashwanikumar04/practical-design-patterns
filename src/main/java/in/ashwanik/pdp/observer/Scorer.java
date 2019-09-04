package in.ashwanik.pdp.observer;

import lombok.Getter;

@Getter
class Scorer implements Observer {
    private int score;

    @Override
    public <T> void onNotify(Event<T> event) {
        GameEntity entity = (GameEntity) event.getPayload();
        score += entity.getKillPoint();
    }
}
