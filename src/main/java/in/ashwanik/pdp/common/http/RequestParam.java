package in.ashwanik.pdp.common.http;

import lombok.Getter;

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

    RequestParam(String url, Map<String, String> headers, Integer timeout) {
        super(timeout, headers);
        this.url = url;
    }

    public static RequestParamsBuilder paramsBuilder() {
        return new RequestParamsBuilder();
    }

    public static class RequestParamsBuilder {
        private String url;
        private Map<String, String> headers;
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

        public RequestParamsBuilder timeout(Integer timeout) {
            this.timeout = timeout;
            return this;
        }

        public RequestParam build() {
            return new RequestParam(url, headers, timeout);
        }
    }
}
