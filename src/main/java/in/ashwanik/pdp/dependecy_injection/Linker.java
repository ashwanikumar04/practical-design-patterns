package in.ashwanik.pdp.dependecy_injection;

import java.util.HashMap;
import java.util.Map;

public class Linker {
    private Map<Class<?>, Object> registered = new HashMap<>();

    public <T> void register(Class<T> key, T instance) {
        registered.put(key, instance);
    }

    public <T> T resolve(Class<T> key) {
        return (T) registered.get(key);
    }
}