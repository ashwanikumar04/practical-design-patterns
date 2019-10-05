package in.ashwanik.pdp.others.unit_of_work;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
class Entity {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
