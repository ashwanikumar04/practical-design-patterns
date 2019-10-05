package in.ashwanik.pdp.creational.builder;

import in.ashwanik.pdp.common.githubjobs.GithubJob;
import in.ashwanik.pdp.common.githubjobs.GithubJobClientContract;
import in.ashwanik.pdp.common.http.RequestParam;
import in.ashwanik.pdp.common.http.RestClient;
import in.ashwanik.pdp.behavioral.iterator.SearchFilter;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GithubJobClient {
    static Integer DEFAULT_TIMEOUT = 2000;
    private final RestClient restClient;

    private String baseUrl;
    private GithubJobClientContract githubJobClientContract;

    private GithubJobClient(RestClient restClient,
                            GithubJobClientBuilder githubJobClientBuilder) {
        this.restClient = restClient;
        this.githubJobClientContract = githubJobClientBuilder.clientContract;
        this.baseUrl = githubJobClientBuilder.baseUrl;
    }

    public static GithubJobClientBuilder builder() {
        return new GithubJobClientBuilder();
    }


    public List<GithubJob> getJobs(SearchFilter searchFilter) {
        return githubJobClientContract.getJobs(restClient, RequestParam
                .paramsBuilder()
                .url(baseUrl + "positions.json")
                .timeout(DEFAULT_TIMEOUT)
                .queryParams(Collections.singletonMap("page", Integer.toString(searchFilter.getPage())))
                .build());
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
        private String baseUrl;

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

        public GithubJobClientBuilder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
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

            GithubJobClient githubJobClient = new GithubJobClient(RestClient.builder().httpClient(localHttpClient).build(), this);
            validate(githubJobClient);
            return githubJobClient;
        }

        private void validate(GithubJobClient githubJobClient) {
            if (githubJobClient.githubJobClientContract == null) {
                throw new IllegalArgumentException("Client contract can't be null");
            }

            if (StringUtils.isBlank(githubJobClient.baseUrl)) {
                throw new IllegalArgumentException("baseUrl can't be null or empty");
            }
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
