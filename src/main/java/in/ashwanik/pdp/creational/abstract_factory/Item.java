package in.ashwanik.pdp.creational.abstract_factory;

import lombok.Getter;

@Getter
class Item {
    private String name;
    private String description;

    Item(String name,
         String description) {
        this.name = name;
        this.description = description;
    }
}
