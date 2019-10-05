package in.ashwanik.pdp.others.unit_of_work;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class ProductDatabase {

    private EnumMap<Operation, Consumer<Product>> operations;
    @Getter
    private Map<String, Product> products = new HashMap<>();

    ProductDatabase() {
        operations = new EnumMap<>(Operation.class);
        operations.put(Operation.INSERT, this::insert);
        operations.put(Operation.UPDATE, this::update);
        operations.put(Operation.DELETE, this::delete);
    }

    void save(Operation operation,
              Product product) {
        operations.get(operation).accept(product);
    }

    private void insert(Product product) {
        products.put(product.getId(), product);
    }

    private void update(Product product) {
        if (StringUtils.isBlank(product.getId())) {
            throw new IllegalArgumentException("Id is missing");
        }
        products.put(product.getId(), product);
    }

    private void delete(Product product) {
        if (StringUtils.isBlank(product.getId())) {
            throw new IllegalArgumentException("Id is missing");
        }
        products.remove(product.getId());
    }
}
