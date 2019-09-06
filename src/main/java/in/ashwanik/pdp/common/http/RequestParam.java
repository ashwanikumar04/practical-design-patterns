package in.ashwanik.pdp.common.http;

import lombok.Getter;
import okhttp3.HttpUrl;

import java.util.Map;

/**
 * Container class to hold the params
 */
@Getter
public class RequestParam extends RestClientParam {
    /**
     * Request URL
     */
    private String url;

    private RequestParam(String url, Map<String, String> headers, Map<String, String> queryParams, Integer timeout) {
        super(timeout, headers, queryParams);
        this.url = getUrlWithQueryParams(url);
    }

    private String getUrlWithQueryParams(String url) {
        if (getQueryParams() != null && !getQueryParams().isEmpty()) {
            HttpUrl.Builder builder = HttpUrl.parse(url).newBuilder();
            for (Map.Entry<String, String> entry : getQueryParams().entrySet()) {
                builder.addQueryParameter(entry.getKey(), entry.getValue());
            }
            return builder.build().toString();
        }
        return url;
    }

    public static RequestParamsBuilder paramsBuilder() {
        return new RequestParamsBuilder();
    }

    public static class RequestParamsBuilder {
        private String url;
        private Map<String, String> headers;
        private Map<String, String> queryParams;
        private Integer timeout;

        RequestParamsBuilder() {
        }

        public RequestParamsBuilder url(String url) {
            this.url = url;
            return this;
        }

        public RequestParamsBuilder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public RequestParamsBuilder queryParams(Map<String, String> queryParams) {
            this.queryParams = queryParams;
            return this;
        }

        public RequestParamsBuilder timeout(Integer timeout) {
            this.timeout = timeout;
            return this;
        }

        public RequestParam build() {
            return new RequestParam(url, headers, queryParams, timeout);
        }
    }
}
