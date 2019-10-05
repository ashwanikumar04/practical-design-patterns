package in.ashwanik.pdp.creational.prototype;


import lombok.Getter;

import java.util.List;

@Getter
class Character {
    private String name;
    private String description;
    private List<Weapon> weapons;
    private int health;

    Character(String name,
              String description,
              int health,
              List<Weapon> weapons) {
        this.name = name;
        this.description = description;
        this.weapons = weapons;
        this.health = health;
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
}
