package in.ashwanik.pdp.structural.bridge;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Customer extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
}
