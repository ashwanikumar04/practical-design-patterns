package in.ashwanik.pdp.others.dependency_injection;

public class Injector {
    private static Injector injector = new Injector();
    private Linker linker = new Linker();

    public static <T> T get(Class<T> key) {
        return injector.linker.resolve(key);
    }

    public static <T> void register(Class<T> key,
                                    T instance) {
        injector.linker.register(key, instance);
    }
}
