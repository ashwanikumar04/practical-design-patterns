package in.ashwanik.pdp.object_pool;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class GameObject {
    private boolean active;
    private String name;

    GameObject(String name) {
        this.name = name;
    }

    GameObject(GameObject poolGameObject) {

    }

    void destroy() {

    }
}
