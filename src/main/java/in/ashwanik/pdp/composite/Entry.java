package in.ashwanik.pdp.composite;

import lombok.Getter;

@Getter
abstract class Entry {
    private String name;

    Entry(String name) {
        this.name = name;
    }

    abstract boolean isDirectory();

    abstract void delete();
}
