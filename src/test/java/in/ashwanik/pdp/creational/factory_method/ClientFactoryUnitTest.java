package in.ashwanik.pdp.creational.factory_method;

import okhttp3.OkHttpClient;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

public class ClientFactoryUnitTest {
    @Test
    public void testClientFactory() {
        assertThat(MessageClientFactory
                .getClient(ClientType.MATTER_MOST, mock(OkHttpClient.class), new AuthenticationConfig()).getClass())
                .isEqualTo(MatterMostClient.class);

    }
}
