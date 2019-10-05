package in.ashwanik.pdp.behavioral.observer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Achievements implements Observer {
    private List<Achievement> achievementList;

    public Achievements() {
        achievementList = new ArrayList<>();
    }

    @Override
    public <T> void onNotify(Event<T> event) {
        GameEntity entity = (GameEntity) event.getPayload();
        if (entity.getKillPoint() > 100) {
            achievementList.add(new Achievement("HighPointKill"));
        }
    }
}
