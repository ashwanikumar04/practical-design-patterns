package in.ashwanik.pdp.prototype;

import java.io.Serializable;
import java.util.List;

public class Orc extends Enemy implements Serializable {
    public static final String ORC = "Orc";
    private static final long serialVersionUID = 425121681855996235L;

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
