package in.ashwanik.pdp.dependecy_injection;

import lombok.Getter;
import okhttp3.OkHttpClient;

import java.io.OutputStream;

@Getter
public class FileDownloader {

    private OkHttpClient okHttpClient;

    public FileDownloader() {
        this.okHttpClient = Injector.get(OkHttpClient.class);
    }

    public void downloadFile(OutputStream outputStream) {

    }
}
