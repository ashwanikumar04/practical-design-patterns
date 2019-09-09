package in.ashwanik.pdp.singleton;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonUnitTest {

    @Test
    public void testSingleton() {
        Game game = Game.getCurrentGame();
        assertThat(game.getGameConfig().getNumberOfPlayers()).isEqualTo(2);
        assertThat(game).isEqualTo(Game.getCurrentGame());
    }
}
