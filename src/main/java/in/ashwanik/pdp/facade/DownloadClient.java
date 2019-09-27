package in.ashwanik.pdp.facade;

import java.io.InputStream;

interface DownloadClient {
    InputStream download(String token,
                         String url);
}
