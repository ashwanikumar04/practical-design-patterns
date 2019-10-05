package in.ashwanik.pdp.creational.prototype;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
class Game {
    private List<Character> characters;

    Game(int numberOfEnemies) {
        Armoury.fill();
        EnemyFactory.init();
        characters = new ArrayList<>(numberOfEnemies);
        IntStream.range(0, numberOfEnemies).forEach(x -> characters.add(EnemyFactory.getRandomEnemy()));
    }
}
