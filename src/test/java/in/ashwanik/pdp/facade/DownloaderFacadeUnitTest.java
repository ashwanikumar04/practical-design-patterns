package in.ashwanik.pdp.facade;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class DownloaderFacadeUnitTest {
    @Test
    public void testFacade() {
        DownloaderFacade downloaderFacade = new DownloaderFacadeImpl(new DownloadClientImpl(), new AuthClientImpl(), new StorageClientImpl());
        assertThatCode(() -> downloaderFacade.download("http://test.com/test")).doesNotThrowAnyException();
    }
}
