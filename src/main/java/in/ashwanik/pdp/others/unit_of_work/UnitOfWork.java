package in.ashwanik.pdp.others.unit_of_work;

public interface UnitOfWork<T> {

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    void commit();
}
