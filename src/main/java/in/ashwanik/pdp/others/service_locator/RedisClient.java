package in.ashwanik.pdp.others.service_locator;

interface RedisClient {
    void save(String key,
              String value);

    String get(String key);
}
