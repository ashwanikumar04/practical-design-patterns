package in.ashwanik.pdp.common.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

/**
 * Container class to pass params
 */
@Getter
@Builder
@AllArgsConstructor
public class RestClientParam {
    /**
     * Request timeout in milliseconds
     */
    private Integer timeout;
    /**
     * Map containing the headers
     */
    private Map<String, String> headers;

    private Map<String, String> queryParams;
}
