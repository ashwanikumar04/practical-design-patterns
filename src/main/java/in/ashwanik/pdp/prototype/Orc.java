package in.ashwanik.pdp.prototype;

import java.util.List;

public class Orc extends Enemy {
    public static final String ORC = "Orc";

    public Orc(String name, String description, int health, List<Weapon> weapons) {
        super(name, description, health, weapons);
    }

    public Orc(Orc orc) {
        super(orc);
    }

    @Override
    public Enemy newInstance() {
        return new Orc(this);
    }
}
