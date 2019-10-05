package in.ashwanik.pdp.behavioral.strategy;

public interface CacheStrategy {

    CacheType save(String key,
                   String value);

    String get(String key);
}
