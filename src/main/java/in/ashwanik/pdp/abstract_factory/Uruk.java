package in.ashwanik.pdp.abstract_factory;

import java.util.List;

class Uruk extends Enemy {
    static final String URUK = "Uruk";

    Uruk(String name,
         String description,
         int health,
         List<Weapon> weapons) {
        super(name, description, health, weapons);
    }

    Uruk(Uruk uruk) {
        super(uruk);
    }

    @Override
    public Enemy newInstance() {
        return new Uruk(this);
    }

}
