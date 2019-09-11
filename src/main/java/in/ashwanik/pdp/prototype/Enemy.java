package in.ashwanik.pdp.prototype;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class Enemy extends Character {
    private int experience;

    public Enemy(String name, String description, int health, List<Weapon> weapons) {
        super(name, description, health, weapons);
        experience = health;
    }

    public Enemy(Enemy enemy) {
        super(enemy.getName(), enemy.getDescription(), enemy.getHealth(), enemy.getWeapons());
        experience = enemy.experience;
    }

    public abstract Enemy newInstance();

    @Override
    public void changeHealth(int delta) {

    }

}
