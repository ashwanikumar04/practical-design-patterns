package in.ashwanik.pdp.singleton;

import in.ashwanik.pdp.common.utils.Json;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.UncheckedIOException;

@Slf4j
@Getter
public class Game {
    private GameConfig gameConfig;

    private Game() {
        try {
            gameConfig = Json.deserialize(IOUtils.toString(this.getClass().getResource("/game_config.json"), "UTF-8"), GameConfig.class);
        } catch (IOException e) {
            log.error("Error loading configuration", e);
            throw new UncheckedIOException(e);
        }
    }

    public static Game getCurrentGame() {
        return SingletonHelper.CURRENT_GAME;
    }

    private static class SingletonHelper {
        private static final Game CURRENT_GAME = new Game();
    }
}
