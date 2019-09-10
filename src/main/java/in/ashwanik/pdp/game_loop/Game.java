package in.ashwanik.pdp.game_loop;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Game {
    private List<GameObject> gameObjects;
    private int monsterCountToFinish;
    @Getter
    private int currentMonsterCount;

    public Game(int numberOfMonsters, int dieMovesForMonsters, int monsterCountToFinish) {
        this.monsterCountToFinish = monsterCountToFinish;
        gameObjects = new ArrayList<>(numberOfMonsters);
        for (int index = 0; index < numberOfMonsters; index++) {
            gameObjects.add(new Monster(dieMovesForMonsters));
        }
    }

    public void play() {
        while (true) {
            gameObjects.forEach(GameObject::update);
            currentMonsterCount = (int) gameObjects.stream().filter(GameObject::isActive).count();
            if (currentMonsterCount <= monsterCountToFinish) {
                break;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                log.error("Error ", e);
            }
        }
    }

}
