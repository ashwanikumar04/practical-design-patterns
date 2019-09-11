package in.ashwanik.pdp.prototype;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Item implements Serializable {
    private static final long serialVersionUID = 4352190977992036193L;
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
