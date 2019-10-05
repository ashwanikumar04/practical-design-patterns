package in.ashwanik.pdp.behavioral.observer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Event<T> {
    T payload;
}
