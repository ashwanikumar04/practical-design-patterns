package in.ashwanik.pdp.prototype;

import lombok.Getter;

@Getter
public class Weapon extends CollectibleItem {
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
