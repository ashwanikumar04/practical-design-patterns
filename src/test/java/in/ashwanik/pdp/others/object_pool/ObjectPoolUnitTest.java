package in.ashwanik.pdp.others.object_pool;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class ObjectPoolUnitTest {
    @Test
    public void testObjectPool() {
        ObjectPoolManager objectPoolManager = ObjectPoolManager.getInstance();
        objectPoolManager.createPool(PoolType.CUBE, getPool(new GameObject("cube"), 1));
        assertThatCode(() -> objectPoolManager.spawn(PoolType.CUBE)).doesNotThrowAnyException();
    }

    private ObjectPool getPool(GameObject poolGameObject,
                               int poolSize) {

        return new ObjectPool(poolGameObject, poolSize, (go) ->
        {
        });
    }
}
