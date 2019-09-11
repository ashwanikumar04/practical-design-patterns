package in.ashwanik.pdp.prototype;

import java.io.Serializable;

public class LongSword extends Weapon implements Serializable {
    public LongSword(String name, String description, int weight, int minimumDamage, int maximumDamage) {
        super(name, description, weight, minimumDamage, maximumDamage);
    }
}
