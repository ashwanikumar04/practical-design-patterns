package in.ashwanik.pdp.others.null_object;

import java.util.Optional;

public class CacheService {
    private Cache cache;

    public CacheService(Cache cache) {
        this.cache = cache;
    }

    void put(String key,
             String value) {
        cache.put(key, value);
    }

    Optional<String> get(String key) {
        return cache.get(key);
    }
}
