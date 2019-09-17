package in.ashwanik.pdp.abstract_factory;

public interface Arena {
    Collectibles createCollectibles();

    Enemy createEnemy();
}
