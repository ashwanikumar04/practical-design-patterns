package in.ashwanik.pdp.trampoline;

public interface TrampolineCompact<T> {
    T get();

    default boolean complete() {
        return true;
    }

    default TrampolineCompact<T> next() {
        return this;
    }

    static <T> TrampolineCompact<T> finish(T value) {
        return () -> value;
    }

    static <T> TrampolineCompact<T> more(TrampolineCompact<TrampolineCompact<T>> next) {
        return new TrampolineCompact<T>() {
            @Override
            public T get() {
                TrampolineCompact<T> current = this;
                while (!current.complete()) {
                    current = current.next();
                }
                return current.get();
            }

            @Override
            public boolean complete() {
                return false;
            }

            @Override
            public TrampolineCompact<T> next() {
                return next.get();
            }
        };
    }
}
