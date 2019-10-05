package in.ashwanik.pdp.others.service_locator;

public class ServiceLocator {
    private static final ServiceLocator locator = new ServiceLocator();
    private Cache nullCache = new NullCache();
    private Cache cache;

    public static ServiceLocator getInstance() {
        return locator;
    }

    public Cache getCache() {
        if (cache == null) {
            return nullCache;
        }
        return cache;
    }

    public void setCache(Cache cache) {
        synchronized (locator) {
            this.cache = cache;
        }
    }
}
