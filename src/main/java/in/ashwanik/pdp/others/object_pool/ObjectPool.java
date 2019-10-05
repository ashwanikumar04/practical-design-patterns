package in.ashwanik.pdp.others.object_pool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

class ObjectPool {
    private GameObject poolGameObject;
    private Deque<GameObject> availableGameObjects;
    private List<GameObject> allGameObjects;

    private Consumer<GameObject> initAction;

    ObjectPool(GameObject gameObject,
               int initialCapacity,
               Consumer<GameObject> initAction) {
        this.poolGameObject = gameObject;
        this.initAction = initAction;
        availableGameObjects = new ArrayDeque<>();
        allGameObjects = new ArrayList<>();
        IntStream.range(0, initialCapacity).forEach(x -> {
            GameObject localGameObject = getGameObject();
            allGameObjects.add(localGameObject);
            availableGameObjects.push(localGameObject);
        });
    }

    private GameObject getGameObject() {
        GameObject result = new GameObject(this.poolGameObject);
        result.setName(this.poolGameObject.getName() + "_" + (allGameObjects.size() + 1));
        if (this.initAction != null) {
            initAction.accept(result);
        }
        result.setActive(false);
        return result;
    }

    GameObject spawn() {
        GameObject result;
        if (!availableGameObjects.isEmpty()) {
            result = getGameObject();
            allGameObjects.add(result);
            availableGameObjects.push(result);
        }
        result = availableGameObjects.pop();
        setActive(result, true);
        return result;
    }

    boolean destroy(GameObject target) {
        availableGameObjects.push(target);
        setActive(target, false);
        return true;
    }

    void clear() {
        for (GameObject item : availableGameObjects) {
            item.destroy();
        }

        for (GameObject item : allGameObjects) {
            item.destroy();
        }
        availableGameObjects.clear();
        allGameObjects.clear();
    }

    void reset() {
        availableGameObjects.clear();
        for (GameObject item : allGameObjects) {
            item.setActive(false);
            availableGameObjects.push(item);
        }
    }

    private void setActive(GameObject target,
                           boolean value) {
        target.setActive(value);
    }
}
