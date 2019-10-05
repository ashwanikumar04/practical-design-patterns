package in.ashwanik.pdp.structural.bridge;

public interface DataProvider<T> {

    T create(T data);

    T update(T data);

    T get(long id);
}
