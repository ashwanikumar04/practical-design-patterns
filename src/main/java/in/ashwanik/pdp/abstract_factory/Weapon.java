package in.ashwanik.pdp.abstract_factory;

import lombok.Getter;

@Getter
class Weapon extends CollectibleItem {
    private int minimumDamage;
    private int maximumDamage;

    Weapon(String name, String description, int weight, int minimumDamage, int maximumDamage) {
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
