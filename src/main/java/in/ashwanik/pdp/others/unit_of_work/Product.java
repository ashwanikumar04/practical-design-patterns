package in.ashwanik.pdp.others.unit_of_work;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
class Product extends Entity {
    private String name;
    private double price;
}
