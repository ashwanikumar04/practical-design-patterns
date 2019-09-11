package in.ashwanik.pdp.prototype;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
public class Game {
    private List<Character> characters;

    public Game(int numberOfEnemies) {
        Armoury.fill();
        EnemyFactory.init();
        characters = new ArrayList<>(numberOfEnemies);
        IntStream.range(0, numberOfEnemies).forEach(x -> characters.add(EnemyFactory.getRandomEnemy()));
    }
}
