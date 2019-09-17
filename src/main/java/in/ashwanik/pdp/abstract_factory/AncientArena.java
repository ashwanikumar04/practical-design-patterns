package in.ashwanik.pdp.abstract_factory;

import java.util.Collections;

import static in.ashwanik.pdp.abstract_factory.Orc.ORC;

public class AncientArena implements Arena {

    @Override
    public Collectibles createCollectibles() {
        return new AncientCollectibles();
    }

    @Override
    public Enemy createEnemy() {
        return new Orc(ORC, "A deadly orc", 100, Collections.singletonList(Armoury.getRandomWeapon()));
    }
}
