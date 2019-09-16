package in.ashwanik.pdp.dependency_injection;

public class Injector {
    private Linker linker = new Linker();
    private static Injector injector = new Injector();

    public static <T> T get(Class<T> key) {
        return injector.linker.resolve(key);
    }

    public static <T> void register(Class<T> key, T instance) {
        injector.linker.register(key, instance);
    }
}
