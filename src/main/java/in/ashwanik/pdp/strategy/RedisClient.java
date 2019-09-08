package in.ashwanik.pdp.strategy;

public interface RedisClient {
    void save(String key, String value);

    String get(String key);
}
