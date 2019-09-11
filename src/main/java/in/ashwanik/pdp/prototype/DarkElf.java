package in.ashwanik.pdp.prototype;

import java.util.List;

public class DarkElf extends Enemy {
    public static final String DARK_ELF = "DarkElf";

    public DarkElf(String name, String description, int health, List<Weapon> weapons) {
        super(name, description, health, weapons);
    }

    public DarkElf(DarkElf darkElf) {
        super(darkElf);
    }

    @Override
    public Enemy newInstance() {
        return new DarkElf(this);
    }
}
