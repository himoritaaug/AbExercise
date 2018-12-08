package hmorita.abexercise.loader;

import hmorita.abexercise.entity.Keyable;
import hmorita.abexercise.factory.EntityFactory;

import java.util.ArrayList;

public interface EntityLoader<E extends Keyable, F extends EntityFactory> {
    public ArrayList<E> load();
}
