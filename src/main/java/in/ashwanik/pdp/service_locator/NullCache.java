package in.ashwanik.pdp.service_locator;

import java.util.Optional;

class NullCache implements Cache {
    @Override
    public void put(String key, String value) {

    }

    @Override
    public Optional<String> get(String key) {
        return Optional.empty();
    }
}
