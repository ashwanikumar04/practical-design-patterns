package in.ashwanik.pdp.composite;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private List<Entry> entries;
    @Getter
    private String name;

    FileSystem(String name) {
        this.name = name;
        this.entries = new ArrayList<>();

    }

    void add(Entry entry) {
        this.entries.add(entry);
    }

    void delete(Entry entry) {
        entry.delete();
        this.entries.remove(entry);
    }

    long numberOfFiles() {
        return entries.stream().filter(entry -> !entry.isDirectory()).count();
    }

    long numberOfDirectories() {
        return entries.stream().filter(Entry::isDirectory).count();
    }
}
