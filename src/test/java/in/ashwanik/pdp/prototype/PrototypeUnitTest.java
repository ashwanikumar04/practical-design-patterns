package in.ashwanik.pdp.prototype;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrototypeUnitTest {
    @Test
    public void testPrototype() {
        Game game = new Game(5);
        assertThat(game.getCharacters().size()).isEqualTo(5);
    }
}
