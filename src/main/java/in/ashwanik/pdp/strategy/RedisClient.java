package in.ashwanik.pdp.strategy;

interface RedisClient {
    void save(String key,
              String value);

    String get(String key);
}
