package in.ashwanik.pdp.behavioral.strategy;

interface RedisClient {
    void save(String key,
              String value);

    String get(String key);
}
