package in.ashwanik.pdp.abstract_factory;

import org.junit.Test;

import static in.ashwanik.pdp.abstract_factory.Orc.ORC;
import static in.ashwanik.pdp.abstract_factory.Uruk.URUK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AbstractFactoryUnitTest {
    @Test
    public void testArena() {
        Game game = new Game(ArenaType.ANCIENT);
        assertThat(game.getEnemy().getName()).isEqualTo(ORC);

        game = new Game(ArenaType.MEDIEVAL);
        assertThat(game.getEnemy().getName()).isEqualTo(URUK);
    }
}
