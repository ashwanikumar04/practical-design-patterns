package in.ashwanik.pdp.strategy;

public class RedisCacheStrategy implements CacheStrategy {
    private RedisClient redisClient;

    RedisCacheStrategy(RedisClient redisClient) {
        this.redisClient = redisClient;
    }

    @Override
    public CacheType save(String key, String value) {
        redisClient.save(key, value);
        return CacheType.REDIS;
    }

    @Override
    public String get(String key) {
        return redisClient.get(key);
    }
}
