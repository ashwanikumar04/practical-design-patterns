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
        assertThat(app.calculateFactorialTrampoline(new BigDecimal(100000), BigDecimal.ONE).compute()).isNotZero();
    }
}
