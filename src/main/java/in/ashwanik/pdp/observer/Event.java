package in.ashwanik.pdp.observer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Event<T> {
    T payload;
}
