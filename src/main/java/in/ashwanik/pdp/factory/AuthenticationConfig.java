package in.ashwanik.pdp.factory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationConfig {
    private String clientId;
    private String clientSecret;
    private String applicationId;
}
