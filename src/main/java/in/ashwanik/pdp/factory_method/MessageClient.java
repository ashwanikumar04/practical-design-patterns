package in.ashwanik.pdp.factory_method;

import okhttp3.OkHttpClient;

public abstract class MessageClient {

    protected OkHttpClient httpClient;
    protected AuthenticationConfig authenticationConfig;

    public MessageClient(OkHttpClient httpClient,
                         AuthenticationConfig authenticationConfig) {
        this.httpClient = httpClient;
        this.authenticationConfig = authenticationConfig;
    }

    public abstract void send(Message message);
}
