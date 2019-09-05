package in.ashwanik.pdp.builder;

import in.ashwanik.pdp.common.GithubJobClientContract;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

public class GithubJobClient {
    static Integer DEFAULT_TIMEOUT = 2000;
    private final OkHttpClient httpClient;

    private String jobSearchUrl;
    private String jobUrl;
    private GithubJobClientContract githubJobClientContract;

    private GithubJobClient(OkHttpClient httpClient, GithubJobClientBuilder githubJobClientBuilder) {
        this.httpClient = httpClient;
        this.githubJobClientContract = githubJobClientBuilder.clientContract;
        this.jobSearchUrl = githubJobClientBuilder.jobSearchUrl;
        this.jobUrl = githubJobClientBuilder.jobUrl;
    }

    public static GithubJobClientBuilder builder() {
        return new GithubJobClientBuilder();
    }

    private void validate() {
        if (httpClient == null) {
            throw new IllegalArgumentException("Http client can't be null");
        }
        if (githubJobClientContract == null) {
            throw new IllegalArgumentException("Client contract can't be null");
        }

        if (StringUtils.isBlank(jobSearchUrl) || StringUtils.isBlank(jobUrl)) {
            throw new IllegalArgumentException("jobSearchUrl or jobUrl can't be null");
        }
    }

    public static class GithubJobClientBuilder {
        private static int TIMEOUT = 30000;
        private static int POOL_SIZE = 5;
        private Integer connectTimeout;
        private Integer writeTimeout;
        private Integer readTimeout;
        private Integer httpClientConnectionPoolSize;
        private OkHttpClient httpClient;
        private GithubJobClientContract clientContract;
        private String jobSearchUrl;
        private String jobUrl;

        private GithubJobClientBuilder() {
        }

        public GithubJobClientBuilder connectTimeout(Integer connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public GithubJobClientBuilder writeTimeout(Integer writeTimeout) {
            this.writeTimeout = writeTimeout;
            return this;
        }

        public GithubJobClientBuilder readTimeout(Integer readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public GithubJobClientBuilder httpClientConnectionPoolSize(Integer httpClientConnectionPoolSize) {
            this.httpClientConnectionPoolSize = httpClientConnectionPoolSize;
            return this;
        }

        public GithubJobClientBuilder httpClient(OkHttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public GithubJobClientBuilder clientContract(GithubJobClientContract clientContract) {
            this.clientContract = clientContract;
            return this;
        }

        public GithubJobClientBuilder jobSearchUrl(String jobSearchUrl) {
            this.jobSearchUrl = jobSearchUrl;
            return this;
        }

        public GithubJobClientBuilder jobUrl(String jobUrl) {
            this.jobUrl = jobUrl;
            return this;
        }

        private OkHttpClient buildHttpClient() {
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                    .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                    .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                    .connectionPool(new ConnectionPool(httpClientConnectionPoolSize, 15, TimeUnit.MINUTES));
            return okHttpClient.build();
        }

        public GithubJobClient build() {
            OkHttpClient localHttpClient;
            if (isClientPropertySet()) {
                setHttpClientDefaults();
                localHttpClient = buildHttpClient();
            } else {
                localHttpClient = httpClient;
            }

            GithubJobClient githubJobClient = new GithubJobClient(localHttpClient, this);
            githubJobClient.validate();
            return githubJobClient;
        }

        private void setHttpClientDefaults() {
            if (connectTimeout == null) {
                connectTimeout = TIMEOUT;
            }
            if (writeTimeout == null) {
                writeTimeout = TIMEOUT;
            }
            if (readTimeout == null) {
                readTimeout = TIMEOUT;
            }
            if (httpClientConnectionPoolSize == null) {
                httpClientConnectionPoolSize = POOL_SIZE;
            }

        }

        private boolean isClientPropertySet() {
            return connectTimeout != null || writeTimeout != null || readTimeout != null || httpClientConnectionPoolSize != null;
        }
    }
}
