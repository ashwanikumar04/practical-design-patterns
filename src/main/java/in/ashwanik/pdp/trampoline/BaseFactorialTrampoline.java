package in.ashwanik.pdp.trampoline;

import java.math.BigDecimal;
import java.util.Optional;

class BaseFactorialTrampoline implements Trampoline<BigDecimal> {

    private final BigDecimal value;

    BaseFactorialTrampoline(BigDecimal value) {
        this.value = value;
    }

    @Override
    public BigDecimal get() {
        return value;
    }

    @Override
    public Optional<Trampoline<BigDecimal>> next() {
        return Optional.empty();
    }
}
