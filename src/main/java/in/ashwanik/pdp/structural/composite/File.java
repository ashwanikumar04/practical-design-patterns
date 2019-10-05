package in.ashwanik.pdp.structural.composite;

public class File extends Entry {

    File(String name) {
        super(name);
    }

    @Override
    boolean isDirectory() {
        return false;
    }

    @Override
    void delete() {

    }
}
