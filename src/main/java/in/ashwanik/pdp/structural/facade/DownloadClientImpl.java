package in.ashwanik.pdp.structural.facade;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.UUID;

public class DownloadClientImpl implements DownloadClient {
    @Override
    public InputStream download(String token,
                                String url) {
        return new ByteArrayInputStream(UUID.randomUUID().toString().getBytes());
    }
}
