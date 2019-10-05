package in.ashwanik.pdp.others.game_loop;

import java.util.concurrent.ThreadLocalRandom;

public class Monster extends GameObject {

    private final int dieMovesCount;
    private int currentMoves;

    public Monster(int dieMovesCount) {
        this.dieMovesCount = dieMovesCount;
    }

    @Override
    public void update() {
        if (!isActive()) {
            return;
        }
        if (ThreadLocalRandom.current().nextBoolean()) {
            currentMoves++;
        }
    }

    @Override
    public boolean isActive() {
        return currentMoves < dieMovesCount;
    }
}
