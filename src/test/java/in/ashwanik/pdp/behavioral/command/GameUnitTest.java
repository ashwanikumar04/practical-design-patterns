package in.ashwanik.pdp.behavioral.command;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameUnitTest {
    @Test
    public void testGameCommand() {
        Game game = new Game();
        game.start();
        assertThat(game.isStarted()).isTrue();
        game.quit();
        assertThat(game.isStarted()).isFalse();
    }
}
