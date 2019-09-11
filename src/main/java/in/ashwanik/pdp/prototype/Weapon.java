package in.ashwanik.pdp.prototype;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Weapon extends CollectibleItem implements Serializable {
    private static final long serialVersionUID = 6185237117225847964L;
    private int minimumDamage;
    private int maximumDamage;

    public Weapon(String name, String description, int weight, int minimumDamage, int maximumDamage) {
        super(name, description, weight);
        this.maximumDamage = maximumDamage;
        this.minimumDamage = minimumDamage;
    }

    public String toString() {
        return "name: " + getName()
                + ", description: " + getDescription()
                + ", minimumDamage: " + this.getMinimumDamage()
                + ", maximumDamage:" + this.getMaximumDamage()
                + ", weight: " + this.getWeight() + " g";
    }
}
