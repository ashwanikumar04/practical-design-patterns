package in.ashwanik.pdp.factory_method;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Message {
    private String to;
    private String from;
    private String text;
    private LocalDateTime sentDate;
}
