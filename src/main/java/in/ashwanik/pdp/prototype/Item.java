package in.ashwanik.pdp.prototype;

import lombok.Getter;

@Getter
public class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
