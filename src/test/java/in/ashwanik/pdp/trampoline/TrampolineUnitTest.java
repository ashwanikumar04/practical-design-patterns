package in.ashwanik.pdp.trampoline;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class TrampolineUnitTest {

    private static final int VAL = 1_00_000;

    @Test
    public void testTrampoline() {
        App app = new App();
        assertThatThrownBy(() -> app.calculateFactorialRecursive(new BigDecimal(VAL))).isInstanceOf(StackOverflowError.class);
        BigDecimal value = app.calculateFactorialTrampoline(new BigDecimal(VAL), BigDecimal.ONE).compute();
        assertThat(value).isNotZero();
        assertThat(app.calculateFactorialTrampolineCompact(new BigDecimal(VAL), BigDecimal.ONE).get())
                .isEqualTo(value);

    }
}
