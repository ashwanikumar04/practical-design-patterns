package in.ashwanik.pdp.dependency_injection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DbConnection {
    private String connectionString;
    private String host;
}
