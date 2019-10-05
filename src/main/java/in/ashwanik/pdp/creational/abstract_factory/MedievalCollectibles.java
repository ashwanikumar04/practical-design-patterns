package in.ashwanik.pdp.creational.abstract_factory;

import java.util.Arrays;
import java.util.List;

public class MedievalCollectibles implements Collectibles {
    @Override
    public List<CollectibleItem> getItems() {
        return Arrays.asList(new LongSword("long sword", "Useful for long range attacks", 150, 20, 40),
                new SpikeHammer("spike hammer", "Good for brutal attacks", 300, 30, 50));
    }
}
