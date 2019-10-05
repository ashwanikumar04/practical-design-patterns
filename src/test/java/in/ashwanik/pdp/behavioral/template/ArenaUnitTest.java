package in.ashwanik.pdp.behavioral.template;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArenaUnitTest {
    @Test
    public void testArena() {
        App app = new App();
        assertThat(app.getArena()).isNotNull();
    }
}
