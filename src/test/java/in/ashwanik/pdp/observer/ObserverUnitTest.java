package in.ashwanik.pdp.observer;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ObserverUnitTest {
    @Test
    public void testGamePlay() throws Exception {
        Game game = new Game();
        game.play();

        assertThat(game.getAchievements().getAchievementList().size()).isEqualTo(1);
        assertThat(game.getScorer().getScore()).isEqualTo(150);
    }
}
