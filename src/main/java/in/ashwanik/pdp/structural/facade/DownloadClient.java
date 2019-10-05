package in.ashwanik.pdp.structural.facade;

import java.io.InputStream;

interface DownloadClient {
    InputStream download(String token,
                         String url);
}
