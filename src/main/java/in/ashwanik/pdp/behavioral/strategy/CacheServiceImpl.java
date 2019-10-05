package in.ashwanik.pdp.behavioral.strategy;

import java.util.EnumMap;

public class CacheServiceImpl implements CacheService {
    private EnumMap<CacheType, CacheStrategy> strategies;

    CacheServiceImpl(RedisClient redisClient) {
        strategies = new EnumMap<>(CacheType.class);
        strategies.put(CacheType.IN_MEMORY, new InMemoryCacheStrategy());
        strategies.put(CacheType.REDIS, new RedisCacheStrategy(redisClient));
        strategies.put(CacheType.REDIS_FALL_BACK_TO_IN_MEMORY,
                new RedisFallBackStrategy(strategies.get(CacheType.REDIS),
                        strategies.get(CacheType.IN_MEMORY)));
    }

    @Override
    public CacheType save(String key,
                          String value,
                          CacheType cacheType) {
        return strategies.get(cacheType).save(key, value);
    }

    @Override
    public String get(String key,
                      CacheType cacheType) {
        return strategies.get(cacheType).get(key);
    }
}
