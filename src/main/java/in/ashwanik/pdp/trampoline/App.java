package in.ashwanik.pdp.trampoline;

import java.math.BigDecimal;

public class App {

    BigDecimal calculateFactorialRecursive(BigDecimal n) {
        if (n.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return n.multiply(calculateFactorialRecursive(n.subtract(BigDecimal.ONE)));
    }

    Trampoline<BigDecimal> calculateFactorialTrampoline(BigDecimal n, BigDecimal sum) {
        if (n.compareTo(BigDecimal.ZERO) < 1) {
            return new BaseFactorialTrampoline(sum);
        } else {
            return new NextFactorialTrampoline(() -> calculateFactorialTrampoline(n.subtract(BigDecimal.ONE), n.multiply(sum)));
        }
    }
}
