package in.ashwanik.pdp.common.http;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Container class for API Response
 */
@Getter
@Setter
@Builder
public class RestResponse<S, E> {
    /**
     * This is the response in case of a success
     */
    private final S success;
    /**
     * Error response
     */
    private final E error;

    /**
     * Check this method to check for success
     *
     * @return TRUE/FALSE
     */
    public boolean isSuccess() {
        return success != null;
    }
}
