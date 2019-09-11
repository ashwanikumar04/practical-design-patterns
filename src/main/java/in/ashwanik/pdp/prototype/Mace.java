package in.ashwanik.pdp.prototype;

import java.io.Serializable;

public class Mace extends Weapon implements Serializable {

    public Mace(String name, String description, int weight, int minimumDamage, int maximumDamage) {
        super(name, description, weight, minimumDamage, maximumDamage);
    }
}
