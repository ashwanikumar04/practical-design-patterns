package in.ashwanik.pdp;

import in.ashwanik.pdp.dependecy_injection.App;
import in.ashwanik.pdp.dependecy_injection.FileDownloader;
import in.ashwanik.pdp.dependecy_injection.Injector;
import okhttp3.OkHttpClient;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class dependency_injection {
    @Test
    public void testDI() {
        App app = new App();
        app.initialize();

        FileDownloader fileDownloader = new FileDownloader();
        assertThat(fileDownloader.getOkHttpClient()).isEqualTo(Injector.get(OkHttpClient.class));


    }
}
