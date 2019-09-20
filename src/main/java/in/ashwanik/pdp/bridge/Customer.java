package in.ashwanik.pdp.bridge;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class Customer extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
}
