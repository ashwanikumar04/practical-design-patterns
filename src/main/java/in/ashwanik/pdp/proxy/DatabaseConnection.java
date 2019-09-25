package in.ashwanik.pdp.proxy;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    public <T> List<T> getList(String query,
                               Class<T> clazz) {
        return new ArrayList<>();
    }

    public <T> T get(String query,
                     Class<T> clazz) {
        return null;
    }
}
