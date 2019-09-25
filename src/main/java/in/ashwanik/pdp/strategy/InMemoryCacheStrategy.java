package in.ashwanik.pdp.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCacheStrategy implements CacheStrategy {
    private Map<String, String> cache;

    InMemoryCacheStrategy() {
        cache = new ConcurrentHashMap<>();
    }

    @Override
    public CacheType save(String key,
                          String value) {
        cache.putIfAbsent(key, value);
        return CacheType.IN_MEMORY;
    }

    @Override
    public String get(String key) {
        return cache.get(key);
    }
}
