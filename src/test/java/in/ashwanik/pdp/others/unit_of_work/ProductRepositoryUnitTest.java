package in.ashwanik.pdp.others.unit_of_work;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductRepositoryUnitTest {
    @Test
    public void testProducts() {
        ProductDatabase productDatabase = new ProductDatabase();
        DbContext context = new DbContext(productDatabase);
        ProductRepository repository = new ProductRepository(context);
        repository.create(Product.builder().name("p").price(1.0).build());
        repository.commit();
        assertThat(productDatabase.getProducts()).isNotNull();
        assertThat(productDatabase.getProducts().size()).isEqualTo(1);
    }
}
