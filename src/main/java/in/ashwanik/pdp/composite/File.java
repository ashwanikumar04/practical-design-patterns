package in.ashwanik.pdp.composite;

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
