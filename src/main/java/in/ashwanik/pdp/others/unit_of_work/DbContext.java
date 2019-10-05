package in.ashwanik.pdp.others.unit_of_work;

import org.apache.commons.collections4.MapUtils;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

class DbContext {
    private EnumMap<Operation, List<Product>> entities;
    private ProductDatabase database;

    DbContext(ProductDatabase database) {
        entities = new EnumMap<>(Operation.class);
        this.database = database;
    }

    void register(Product entity,
                  Operation operation) {
        entities.putIfAbsent(operation, new ArrayList<>());
        entities.get(operation).add(entity);
    }

    void commit() {
        if (MapUtils.isNotEmpty(entities)) {
            entities.forEach((operation, list) -> list
                    .forEach(entity -> database.save(operation, entity)));
        }
    }
}
