package in.ashwanik.pdp.prototype;


import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class Character implements Serializable {
    private static final long serialVersionUID = 2166181694916422504L;
    private String name;
    private String description;
    private List<Weapon> weapons;
    private int health;

    public Character(String name, String description, int health, List<Weapon> weapons) {
        this.name = name;
        this.description = description;
        this.weapons = weapons;
        this.health = health;
    }

    public boolean isDead() {
        return health == 0;
    }

    public boolean hasWeapon() {
        return false;

    }

    public void attack(Character character) {

    }

    public void changeHealth(int delta) {

    }
}
