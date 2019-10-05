package in.ashwanik.pdp.structural.facade;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

@AllArgsConstructor
public class DownloaderFacadeImpl implements DownloaderFacade {

    private DownloadClient downloadClient;
    private AuthClient authClient;
    private StorageClient storageClient;

    @Override
    public void download(String url) {
        String token = authClient.authorize();
        try {
            try (InputStream inputStream = downloadClient.download(token, url)) {
                storageClient.store(inputStream);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
