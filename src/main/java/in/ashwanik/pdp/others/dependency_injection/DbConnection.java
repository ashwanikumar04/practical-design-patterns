package in.ashwanik.pdp.others.dependency_injection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DbConnection {
    private String connectionString;
    private String host;
}
