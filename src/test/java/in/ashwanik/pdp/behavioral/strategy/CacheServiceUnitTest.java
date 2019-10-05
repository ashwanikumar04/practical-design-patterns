package in.ashwanik.pdp.behavioral.strategy;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

public class CacheServiceUnitTest {
    private CacheService cacheService;

    @Before
    public void setup() {
        cacheService = new CacheServiceImpl(mock(RedisClient.class));
    }

    @Test
    public void givenCacheTypeWhenSavedThenSavedToGivenCacheType() {
        CacheType cacheType = cacheService.save("key", "value", CacheType.IN_MEMORY);
        String value = cacheService.get("key", cacheType);
        assertThat(value).isEqualTo("value");
    }
}
