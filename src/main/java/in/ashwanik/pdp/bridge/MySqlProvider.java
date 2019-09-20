package in.ashwanik.pdp.bridge;

public class MySqlProvider<T extends BaseEntity> implements DataProvider<T> {

    @Override
    public T create(T data) {
        return null;
    }

    @Override
    public T update(T data) {
        return null;
    }

    @Override
    public T get(long id) {
        return null;
    }
}
