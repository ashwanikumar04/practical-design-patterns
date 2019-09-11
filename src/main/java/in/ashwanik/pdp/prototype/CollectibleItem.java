package in.ashwanik.pdp.prototype;

import lombok.Getter;

@Getter
public class CollectibleItem extends Item {
    private int weight;

    public CollectibleItem(String name, String description, int weight) {
        super(name, description);
        this.weight = weight;
    }
}
