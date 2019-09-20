package in.ashwanik.pdp.bridge;

import java.time.LocalDateTime;

public class RedisProvider<T extends BaseEntity> implements DataProvider<T> {

    @Override
    public T create(T data) {
        data.setId(1);
        data.setCreatedTime(LocalDateTime.now());
        return data;
    }

    @Override
    public T update(T data) {
        data.setModifiedTime(LocalDateTime.now());
        return data;
    }

    @Override
    public T get(long id) {
        return null;
    }
}
