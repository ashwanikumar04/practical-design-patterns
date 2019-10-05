package in.ashwanik.pdp.creational.prototype;

import java.util.List;

class Orc extends Enemy {
    static final String ORC = "Orc";

    Orc(String name,
        String description,
        int health,
        List<Weapon> weapons) {
        super(name, description, health, weapons);
    }

    Orc(Orc orc) {
        super(orc);
    }

    @Override
    Enemy newInstance() {
        return new Orc(this);
    }
}
