package in.ashwanik.pdp.others.null_object;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class NullCacheUnitTest {
    @Test
    public void testNullCache() {
        Cache cache = new NullCache();
        CacheService cacheService = new CacheService(cache);

        assertThatCode(() -> cacheService.put("key", "value")).doesNotThrowAnyException();

    }
}
