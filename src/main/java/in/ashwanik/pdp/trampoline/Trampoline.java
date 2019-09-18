package in.ashwanik.pdp.trampoline;

import java.util.Optional;

public interface Trampoline<T> {

    T get();

    Optional<Trampoline<T>> next();

    default T compute() {
        Trampoline<T> current = this;
        while (current.next().isPresent()) {
            current = current.next().get();
        }
        return current.get();
    }
}
