package in.ashwanik.pdp.trampoline;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class TrampolineUnitTest {

    @Test
    public void testTrampoline() {
        App app = new App();
        assertThatThrownBy(() -> app.calculateFactorialRecursive(new BigDecimal(100000))).isInstanceOf(StackOverflowError.class);
        BigDecimal value = app.calculateFactorialTrampoline(new BigDecimal(100000), BigDecimal.ONE).compute();
        assertThat(value).isNotZero();
        assertThat(app.calculateFactorialTrampolineCompact(new BigDecimal(100000), BigDecimal.ONE).get())
                .isEqualTo(value);

    }
}
