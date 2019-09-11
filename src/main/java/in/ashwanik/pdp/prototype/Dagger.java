package in.ashwanik.pdp.prototype;

import java.io.Serializable;

public class Dagger extends Weapon implements Serializable {
    public Dagger(String name, String description, int weight, int minimumDamage, int maximumDamage) {
        super(name, description, weight, minimumDamage, maximumDamage);
    }
}
