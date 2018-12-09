package hmorita.abexercise.map;

import hmorita.abexercise.entity.Keyable;

import java.util.HashMap;

abstract public class EntityMap<E extends Keyable, T> {

    protected HashMap<Long, T> entityMap;

    abstract public void addToMap(E e);

    public T getMapValue(long key) {
        if(entityMap.containsKey(key)) {
            return entityMap.get(key);
        }
        return null;
    }

    public HashMap<Long, T> getMap() {
        return entityMap;
    }
}
