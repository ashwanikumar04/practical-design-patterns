package in.ashwanik.pdp.others.dependency_injection;

import okhttp3.OkHttpClient;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DIUnitTest {
    @Test
    public void testDI() {
        App app = new App();
        app.initialize();

        FileDownloader fileDownloader = new FileDownloader();
        assertThat(fileDownloader.getOkHttpClient()).isEqualTo(Injector.get(OkHttpClient.class));


    }
}
