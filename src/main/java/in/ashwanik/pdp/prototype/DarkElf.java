package in.ashwanik.pdp.prototype;

import java.io.Serializable;
import java.util.List;

public class DarkElf extends Enemy implements Serializable {
    public static final String DARK_ELF = "DarkElf";

    private static final long serialVersionUID = 425121681855996235L;

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
