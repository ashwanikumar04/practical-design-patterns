package in.ashwanik.pdp.null_object;

import java.util.Optional;

class NullCache implements Cache {
    @Override
    public void put(String key,
                    String value) {

    }

    @Override
    public Optional<String> get(String key) {
        return Optional.empty();
    }
}
