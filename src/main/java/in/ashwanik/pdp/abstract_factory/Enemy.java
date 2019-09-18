package in.ashwanik.pdp.abstract_factory;

import lombok.Getter;

import java.util.List;

@Getter
abstract class Enemy {
    private int experience;
    private String name;
    private String description;
    private List<Weapon> weapons;
    private int health;

    Enemy(String name, String description, int health, List<Weapon> weapons) {
        this.name = name;
        this.description = description;
        this.weapons = weapons;
        this.health = health;
    }

    Enemy(Enemy enemy) {
        this(enemy.getName(), enemy.getDescription(), enemy.getHealth(), enemy.getWeapons());
        experience = enemy.experience;
    }

    boolean isDead() {
        return health == 0;
    }

    boolean hasWeapon() {
        return false;

    }

    void attack(Character character) {

    }

    void changeHealth(int delta) {

    }

    abstract Enemy newInstance();
}
