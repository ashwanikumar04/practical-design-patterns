package in.ashwanik.pdp.service_locator;

import java.util.Optional;

interface Cache {

    void put(String key,
             String value);

    Optional<String> get(String key);

}
