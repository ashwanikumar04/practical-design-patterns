package in.ashwanik.pdp.abstract_factory;

import lombok.Getter;

import java.util.List;

@Getter
class Game {
    private List<CollectibleItem> collectibles;
    private Enemy enemy;

    Game(ArenaType arenaType) {
        Armoury.fill();
        Arena arena = ArenaFactory.getArena(arenaType);
        collectibles = arena.createCollectibles().getItems();
        enemy = arena.createEnemy();
    }

    static class ArenaFactory {
        static Arena getArena(ArenaType arenaType) {
            switch (arenaType) {
                case ANCIENT:
                    return new AncientArena();
                case MEDIEVAL:
                default:
                    return new MedievalArena();
            }
        }
    }
}
