package in.ashwanik.pdp.creational.factory_method;

import okhttp3.OkHttpClient;

public class MatterMostClient extends MessageClient {
    public MatterMostClient(OkHttpClient httpClient,
                            AuthenticationConfig authenticationConfig) {
        super(httpClient, authenticationConfig);
    }

    @Override
    public void send(Message message) {

    }
}
