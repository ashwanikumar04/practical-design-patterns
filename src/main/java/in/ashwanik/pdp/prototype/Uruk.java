package in.ashwanik.pdp.prototype;

import java.util.List;

public class Uruk extends Enemy {
    public static final String URUK = "Uruk";

    public Uruk(String name, String description, int health, List<Weapon> weapons) {
        super(name, description, health, weapons);
    }

    public Uruk(Uruk uruk) {
        super(uruk);
    }

    @Override
    public Enemy newInstance() {
        return new Uruk(this);
    }

}
