package in.ashwanik.pdp.structural.composite;

public class Shortcut extends Entry {

    private Entry entry;

    Shortcut(String name,
             Entry entry) {
        super(name);
        this.entry = entry;
    }

    @Override
    boolean isDirectory() {
        return entry.isDirectory();
    }

    @Override
    void delete() {

    }
}
