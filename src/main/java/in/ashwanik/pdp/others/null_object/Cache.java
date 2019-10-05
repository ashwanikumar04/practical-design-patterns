package in.ashwanik.pdp.others.null_object;

import java.util.Optional;

interface Cache {

    void put(String key,
             String value);

    Optional<String> get(String key);

}
