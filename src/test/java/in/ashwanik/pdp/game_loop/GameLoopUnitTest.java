package in.ashwanik.pdp.game_loop;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameLoopUnitTest {
    @Test
    public void testGameLoop() {
        Game game = new Game(1000, 100, 50);
        game.play();
        assertThat(game.getCurrentMonsterCount()).isGreaterThan(0);
    }
}
