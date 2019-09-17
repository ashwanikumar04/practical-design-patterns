package in.ashwanik.pdp.abstract_factory;

import lombok.Getter;

@Getter
class CollectibleItem extends Item {
    private int weight;

    CollectibleItem(String name, String description, int weight) {
        super(name, description);
        this.weight = weight;
    }
}
