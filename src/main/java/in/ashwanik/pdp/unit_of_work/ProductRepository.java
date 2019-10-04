package in.ashwanik.pdp.unit_of_work;

import java.time.LocalDateTime;
import java.util.UUID;

class ProductRepository implements UnitOfWork<Product> {

    private final DbContext context;

    public ProductRepository(DbContext context) {
        this.context = context;
    }

    @Override
    public void create(Product product) {
        product.setId(UUID.randomUUID().toString());
        product.setCreatedAt(LocalDateTime.now());
        context.register(product, Operation.INSERT);
    }

    @Override
    public void update(Product product) {
        product.setModifiedAt(LocalDateTime.now());
        context.register(product, Operation.UPDATE);
    }

    @Override
    public void delete(Product product) {
        context.register(product, Operation.DELETE);
    }

    @Override
    public void commit() {
        context.commit();
    }
}
