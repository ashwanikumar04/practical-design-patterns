package in.ashwanik.pdp.prototype;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static in.ashwanik.pdp.prototype.DarkElf.DARK_ELF;
import static in.ashwanik.pdp.prototype.Orc.ORC;
import static in.ashwanik.pdp.prototype.Uruk.URUK;

class EnemyFactory {
    private static EnemyFactory instance;
    private static String[] enemyTypes = {ORC, URUK, DARK_ELF};
    private Random random;
    private Map<String, Enemy> enemies;

    private EnemyFactory() {
        enemies = new HashMap<>();
        random = new Random();

        enemies.put(ORC, (new Orc(ORC, "A deadly orc", 100, Collections.singletonList(Armoury.getRandomWeapon()))));
        enemies.put(URUK, (new Uruk(URUK, "A deadly uruk", 100, Collections.singletonList(Armoury.getRandomWeapon()))));
        enemies.put(DARK_ELF, new DarkElf(DARK_ELF, "A deadly dark elf", 100, Collections.singletonList(Armoury.getRandomWeapon())));
    }

    static void init() {
        instance = new EnemyFactory();
    }

    static Enemy getRandomEnemy() {
        EnemyFactory enemyFactory = instance;
        return enemyFactory.enemies.get(enemyTypes[enemyFactory.random.nextInt(enemyTypes.length)]).newInstance();
    }
}
