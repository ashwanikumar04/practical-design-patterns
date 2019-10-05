package in.ashwanik.pdp.creational.abstract_factory;

import java.util.Arrays;
import java.util.List;

public class AncientCollectibles implements Collectibles {
    @Override
    public List<CollectibleItem> getItems() {
        return Arrays.asList(new Dagger("dagger", "Useful for short range attacks", 50, 5, 20),
                new Mace("mace", "Good for brutal attacks", 250, 25, 50));
    }
}
