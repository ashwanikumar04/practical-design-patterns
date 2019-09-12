package in.ashwanik.pdp.factory_method;

import okhttp3.OkHttpClient;

public class MessageClientFactory {

    public static MessageClient getClient(ClientType clientType,
                                          OkHttpClient httpClient,
                                          AuthenticationConfig authenticationConfig) {
        switch (clientType) {
            case JABBER:
                return new JabberClient(httpClient, authenticationConfig);
            case SLACK:
                return new SlackClient(httpClient, authenticationConfig);
            case MATTER_MOST:
                return new MatterMostClient(httpClient, authenticationConfig);
            default:
                throw new IllegalArgumentException("Unknown client type");
        }
    }
}
