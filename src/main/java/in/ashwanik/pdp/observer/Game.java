package in.ashwanik.pdp.observer;

import lombok.Getter;

@Getter
public class Game {
    private Scorer scorer;
    private GameEntityStats gameEntityStats;
    private Achievements achievements;

    public Game() {
        gameEntityStats = new GameEntityStats();
        scorer = new Scorer();
        achievements = new Achievements();
        gameEntityStats.addObserver(achievements);
        gameEntityStats.addObserver(scorer);
    }

    public void play() throws Exception {
        GameEntity gameEntity = GameEntity.builder().killPoint(150).name("monster").build();
        Thread.sleep(1000);
        gameEntityStats.updateStats(gameEntity);
    }
}
