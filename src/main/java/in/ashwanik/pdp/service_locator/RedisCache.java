package in.ashwanik.pdp.service_locator;


import java.util.Optional;

class RedisCache implements Cache {
    private RedisClient redisClient;

    public RedisCache(RedisClient redisClient) {
        this.redisClient = redisClient;
    }

    @Override
    public void put(String key, String value) {
        redisClient.save(key, value);
    }

    @Override
    public Optional<String> get(String key) {
        return Optional.ofNullable(redisClient.get(key));
    }
}
