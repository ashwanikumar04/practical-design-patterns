package in.ashwanik.pdp.creational.singleton;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameConfig {
    @SerializedName("number_of_players")
    private int numberOfPlayers;
}
