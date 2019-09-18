package in.ashwanik.pdp.trampoline;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Supplier;

class NextFactorialTrampoline implements Trampoline<BigDecimal> {

    private final Supplier<Trampoline<BigDecimal>> next;

    NextFactorialTrampoline(Supplier<Trampoline<BigDecimal>> next) {
        this.next = next;
    }

    @Override
    public BigDecimal get() {
        return null;
    }

    @Override
    public Optional<Trampoline<BigDecimal>> next() {
        return Optional.of(next.get());
    }
}
