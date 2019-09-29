package in.ashwanik.pdp.object_pool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ObjectPoolManager {
    private static ObjectPoolManager instance = new ObjectPoolManager();
    private Map<PoolType, ObjectPool> objectPools = new ConcurrentHashMap<>();

    private ObjectPoolManager() {

    }

    public static ObjectPoolManager getInstance() {
        return instance;
    }

    void createPool(PoolType type,
                    ObjectPool pool) {
        if (!objectPools.containsKey(type)) {
            objectPools.put(type, pool);
        } else {
            objectPools.get(type).clear();
        }
    }

    void reset() {
        objectPools.forEach((key, value) -> value.reset());
    }

    ObjectPool getPool(PoolType type) {
        return objectPools.get(type);
    }

    void spawn(PoolType type) {
        if (!objectPools.isEmpty()) {
            getPool(type).spawn();
        }
    }

    void destroy(PoolType type,
                 GameObject target) {
        if (!objectPools.isEmpty()) {
            getPool(type).destroy(target);
        }
    }
}
