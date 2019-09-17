package in.ashwanik.pdp.abstract_factory;

import java.util.Collections;

import static in.ashwanik.pdp.abstract_factory.Uruk.URUK;

public class MedievalArena implements Arena {
    @Override
    public Collectibles createCollectibles() {
        return new MedievalCollectibles();
    }

    @Override
    public Enemy createEnemy() {
        return new Uruk(URUK, "A deadly uruk", 100, Collections.singletonList(Armoury.getRandomWeapon()));
    }
}
