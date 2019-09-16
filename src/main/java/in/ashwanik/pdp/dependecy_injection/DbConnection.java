package in.ashwanik.pdp.dependecy_injection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DbConnection {
    private String connectionString;
    private String host;
}
