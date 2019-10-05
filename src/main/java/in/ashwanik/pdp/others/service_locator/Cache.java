package in.ashwanik.pdp.others.service_locator;

import java.util.Optional;

interface Cache {

    void put(String key,
             String value);

    Optional<String> get(String key);

}
