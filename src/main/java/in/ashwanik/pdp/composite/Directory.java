package in.ashwanik.pdp.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Directory extends Entry {

    private List<Entry> entries;


    Directory(String name) {
        super(name);
        entries = new ArrayList<>();
    }


    void addEntry(Entry entry) {
        this.entries.add(entry);
    }

    Optional<Entry> find(String name) {
        return entries.stream().filter(x -> x.getName().equals(name)).findFirst();
    }

    @Override
    boolean isDirectory() {
        return true;
    }

    @Override
    void delete() {
        entries.forEach(Entry::delete);
    }
}
