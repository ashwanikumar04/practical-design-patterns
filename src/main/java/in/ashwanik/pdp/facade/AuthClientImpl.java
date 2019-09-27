package in.ashwanik.pdp.facade;

import java.util.UUID;

public class AuthClientImpl implements AuthClient {
    @Override
    public String authorize() {
        return UUID.randomUUID().toString();
    }
}
