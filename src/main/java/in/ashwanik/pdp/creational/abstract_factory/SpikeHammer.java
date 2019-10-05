package in.ashwanik.pdp.creational.abstract_factory;

class SpikeHammer extends Weapon {

    SpikeHammer(String name,
                String description,
                int weight,
                int minimumDamage,
                int maximumDamage) {
        super(name, description, weight, minimumDamage, maximumDamage);
    }
}
