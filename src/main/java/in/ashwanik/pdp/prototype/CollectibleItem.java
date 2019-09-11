package in.ashwanik.pdp.prototype;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class CollectibleItem extends Item implements Serializable {

    private static final long serialVersionUID = -7595122313827713642L;
    private int weight;

    public CollectibleItem(String name, String description, int weight) {
        super(name, description);
        this.weight = weight;
    }
}
