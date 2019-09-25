package in.ashwanik.pdp.service_locator;

interface RedisClient {
    void save(String key,
              String value);

    String get(String key);
}
