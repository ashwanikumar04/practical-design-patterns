package in.ashwanik.pdp.observer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Event<T> {
    T payload;
}
