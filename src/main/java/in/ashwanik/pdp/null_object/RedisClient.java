package in.ashwanik.pdp.null_object;

interface RedisClient {
    void save(String key, String value);

    String get(String key);
}
