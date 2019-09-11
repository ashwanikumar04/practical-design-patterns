package in.ashwanik.pdp.prototype;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@EqualsAndHashCode
public abstract class Enemy extends Character implements Serializable {
    private static final long serialVersionUID = -8785535851108263852L;
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
