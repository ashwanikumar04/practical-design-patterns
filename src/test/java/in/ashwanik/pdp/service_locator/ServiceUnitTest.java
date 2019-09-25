package in.ashwanik.pdp.service_locator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ServiceUnitTest {
    @Test
    public void testServiceLocator() {
        Cache cache = new RedisCache(new RedisClient() {
            @Override
            public void save(String key,
                             String value) {

            }

            @Override
            public String get(String key) {
                return null;
            }
        });

        ServiceLocator.getInstance().setCache(cache);


        assertThat(ServiceLocator.getInstance().getCache().getClass()).isEqualTo(RedisCache.class);

    }
}
