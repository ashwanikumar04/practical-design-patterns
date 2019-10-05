package in.ashwanik.pdp.behavioral.strategy;

import org.apache.commons.lang3.StringUtils;

public class RedisFallBackStrategy implements CacheStrategy {
    private CacheStrategy inMemoryCache;
    private CacheStrategy redisCache;

    RedisFallBackStrategy(CacheStrategy inMemoryCache,
                          CacheStrategy redisCache) {
        this.inMemoryCache = inMemoryCache;
        this.redisCache = redisCache;
    }

    @Override
    public CacheType save(String key,
                          String value) {
        try {
            return redisCache.save(key, value);
        } catch (Exception ex) {
            return inMemoryCache.save(key, value);
        }
    }

    @Override
    public String get(String key) {
        String value = redisCache.get(key);
        if (StringUtils.isBlank(value)) {
            return inMemoryCache.get(key);
        }
        return value;
    }
}
