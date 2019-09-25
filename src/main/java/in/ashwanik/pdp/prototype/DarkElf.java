package in.ashwanik.pdp.prototype;

import java.util.List;

class DarkElf extends Enemy {
    static final String DARK_ELF = "DarkElf";

    DarkElf(String name,
            String description,
            int health,
            List<Weapon> weapons) {
        super(name, description, health, weapons);
    }

    DarkElf(DarkElf darkElf) {
        super(darkElf);
    }

    @Override
    public Enemy newInstance() {
        return new DarkElf(this);
    }
}
